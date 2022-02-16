import { Component, OnInit } from '@angular/core';
import { io } from 'socket.io-client';
import {SocketioService} from "../services/socketio.service";

@Component({
  selector: 'app-web-socket',
  templateUrl: './web-socket.component.html',
  styleUrls: ['./web-socket.component.sass']
})
export class WebSocketComponent implements OnInit {

  constructor(private socketService: SocketioService) { }

  ngOnInit() {
    this.socketService.setupSocketConnection();
  }

  ngOnDestroy() {
    this.socketService.disconnect();
  }
}
