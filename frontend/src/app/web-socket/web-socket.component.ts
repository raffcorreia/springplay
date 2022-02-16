import { Component, OnInit } from '@angular/core';
import { io } from 'socket.io-client';

@Component({
  selector: 'app-web-socket',
  templateUrl: './web-socket.component.html',
  styleUrls: ['./web-socket.component.sass']
})
export class WebSocketComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
