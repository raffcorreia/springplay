import {Component, OnInit} from '@angular/core';
import {SocketIOService} from "../services/socketio.service";
import {FormBuilder} from "@angular/forms";
import {StompClientService} from "../services/stomp/stomp-client.service";
import {SecurityService} from "../services/security.service";
import {DatePipe} from "@angular/common";

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
              private stompService: StompClientService,
              private securityService: SecurityService,
              public datePipe: DatePipe
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
      this.updateMsgBoardSpring(response.user, response.content);
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
    this.securityService.getUserDetails().then(data => {
      this.stompService.sendMessage(data.name, this.txtSendSTOMP);
    });
  }

  private updateMsgBoardSpring(user: string, newMessage: string) {
    let currentDateTime = this.datePipe.transform((new Date), 'MM/dd/yyyy h:mm:ss');
    console.log(currentDateTime);
    this.txtMsgsSTOMP += currentDateTime + " (" + user + "):\n- " + newMessage + "\n";
  }
}
