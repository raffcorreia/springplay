import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {io} from "socket.io-client";

@Injectable({
  providedIn: 'root'
})
export class SocketioService {

  socket;

  constructor() {  }

  setupSocketConnection() {
    this.socket = io(environment.SOCKET_ENDPOINT)

    this.socket.on('my broadcast', (data: string) => {
      console.log(data);
    });
  }

  disconnect() {
    if (this.socket) {
      this.socket.disconnect();
    }
  }

}