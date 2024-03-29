import {EventEmitter, Injectable, Output} from '@angular/core';
import {io} from "socket.io-client";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class SocketIOService {

  @Output() public msgReceived = new EventEmitter();

  private socket;
  private eventName : string;

  constructor() {  }

  setupSocketConnection(eventName : string) {
    console.log("Entering; setupSocketConnection(" + eventName + ") " + environment.SOCKET_ENDPOINT_SOCKET_IO);
    this.eventName = eventName;
    this.socket = io(environment.SOCKET_ENDPOINT_SOCKET_IO);

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

  disconnect() {
    if (this.socket) {
      this.socket.disconnect();
    }
  }

  sendMessage(msgStr: string) {
    if (this.socket) this.socket.emit('message', msgStr);
  }
}