import { Component, OnInit } from '@angular/core';
import {SocketioService} from "../services/socketio.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

const socketIOEventName : string = "socketIOEvent";

@Component({
  selector: 'app-web-socket',
  templateUrl: './web-socket.component.html',
  styleUrls: ['./web-socket.component.sass']
})
export class WebSocketComponent implements OnInit {

  public stIONode_msgsTxt: any;
  public stIONode_sendTxt: any;

  constructor(private formBuilder: FormBuilder,
              private socketService: SocketioService
  ) {
    this.stIONode_msgsTxt = "";
    this.stIONode_sendTxt = "";

  }

  ngOnInit() {
    this.socketService.setupSocketConnection(socketIOEventName);

    this.socketService.msgReceived.subscribe( response => {
      this.updateMsgBoard(response);
    })
  }

  ngOnDestroy() {
    this.socketService.disconnect();
  }

  sIONode_send() {
    this.updateMsgBoard(this.socketService.sendMessage(this.stIONode_sendTxt));
  }

  private updateMsgBoard(newMessage: string) {
    this.stIONode_msgsTxt += newMessage + "\n";
  }
}
