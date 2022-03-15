import {EventEmitter, Injectable, Output} from '@angular/core';
import {RxStompService} from "./rx-stomp.service";


@Injectable({
  providedIn: 'root'
})
export class StompClientService {

  @Output() public msgReceived = new EventEmitter();

  constructor(private rxStompService: RxStompService) {  }

  setupSocketConnection(eventName : string) {
    this.rxStompService.activate();
    this.rxStompService.watch('/topic/greetings').subscribe((message: any) => {
      this.onMessageReceived(message.body)
    });
  }

  onMessageReceived(message) {
    this.msgReceived.emit(JSON.parse(message).content)
  }

  disconnect() {
    this.rxStompService.deactivate();
  }

  sendMessage(msgStr: string) {
    this.rxStompService.publish({
      destination: '/topic/greetings',
      body: JSON.stringify({content: msgStr})
    });
  }
}