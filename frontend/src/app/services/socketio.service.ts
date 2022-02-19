import {EventEmitter, Injectable, Output} from '@angular/core';
import {environment} from "../../environments/environment";
import {io} from "socket.io-client";

const user : string = "user";

const myRandomChatRoomId = 'myRandomChatRoomId';

@Injectable({
  providedIn: 'root'
})
export class SocketioService {

  @Output() public msgReceived = new EventEmitter();

  private socket;
  private eventName : string;

  constructor() {  }

  setupSocketConnection(eventName : string) {
    console.log("Entering; setupSocketConnection()")
    this.eventName = eventName;
    this.socket = io(environment.SOCKET_IO_ENDPOINT)

    this.socket.on(this.eventName, (data: string) => {
      console.log(data);
      this.msgReceived.emit(data);
    });

    this.socket.on('message', msg => {
      console.log('Room event received!');
      console.log(msg);
      this.msgReceived.emit(msg);
    });
  }

  joinRoom(roomName: string) {
    this.socket.emit('join', roomName);
  }

  disconnect() {
    if (this.socket) {
      this.socket.disconnect();
    }
  }

  sendMessage(msgObj: {message, roomName}) {
    if (this.socket) this.socket.emit('message', msgObj);
  }
}