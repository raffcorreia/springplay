import {EventEmitter, Injectable, Output} from '@angular/core';
import {environment} from "../../environments/environment";
import {io} from "socket.io-client";

const user : string = "user";

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
      this.msgReceived.emit(data);
      console.log(data);
    });
  }

  disconnect() {
    if (this.socket) {
      this.socket.disconnect();
    }
  }

  sendMessage(stIONode_sendTxt: any) : string {
    var msg = this.getFullTimestamp() + " (" + user + "): " + stIONode_sendTxt;
    this.socket.emit(this.eventName, msg);
    return msg;
  }

  private getFullTimestamp () {
    const pad = (n,s=2) => (`${new Array(s).fill(0)}${n}`).slice(-s);
    const d = new Date();

    return `${pad(d.getFullYear(),4)}-${pad(d.getMonth()+1)}-${pad(d.getDate())} ${pad(d.getHours())}:${pad(d.getMinutes())}:${pad(d.getSeconds())}.${pad(d.getMilliseconds(),3)}`;
  }
}