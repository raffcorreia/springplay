import { Component, OnInit } from '@angular/core';
import {SocketIOService} from "../services/socketio.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {StompClientService} from "../services/stomp/stomp-client.service";

const EVENT_NAME_NODE = "socketIOEvent";
const EVENT_NAME_SPRING = "/topic/greetings";

@Component({
  selector: 'app-web-socket',
  templateUrl: './web-socket.component.html',
  styleUrls: ['./web-socket.component.sass']
})
export class WebSocketComponent implements OnInit {

  public txtMsgsSIO: any;
  public txtSendSIO: any;
  public txtMsgsSTOMP: any;
  public txtSendSTOMP: any;

  constructor(private formBuilder: FormBuilder,
              private socketIOService: SocketIOService,
              private stompService: StompClientService
  ) {

    this.txtMsgsSIO = "";
    this.txtSendSIO = "";
    this.txtMsgsSTOMP = "";
    this.txtSendSTOMP = "";
  }

  ngOnInit() {
    // Node
    this.socketIOService.setupSocketConnection(EVENT_NAME_NODE);

    this.socketIOService.msgReceived.subscribe( response => {
      this.updateMsgBoardNode(response);
    })


    // Spring
    this.stompService.setupSocketConnection(EVENT_NAME_SPRING);

    this.stompService.msgReceived.subscribe( response => {
      this.updateMsgBoardSpring(response);
    })
  }

  ngOnDestroy() {
    this.socketIOService.disconnect();
  }

  sendMessageSIO() {
    this.socketIOService.sendMessage(this.txtSendSIO);
  }

  private updateMsgBoardNode(newMessage: string) {
    this.txtMsgsSIO += newMessage + "\n";
  }

  sendMessageSTOMP() {
    this.stompService.sendMessage(this.txtSendSTOMP);
  }

  private updateMsgBoardSpring(newMessage: string) {
    this.txtMsgsSTOMP += newMessage + "\n";
  }
}
