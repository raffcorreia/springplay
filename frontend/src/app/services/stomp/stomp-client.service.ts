import {EventEmitter, Injectable, Output} from '@angular/core';
import {RxStompService} from "./rx-stomp.service";


@Injectable({
  providedIn: 'root'
})
export class StompClientService {
  @Output() public msgReceived = new EventEmitter();
  private eventName : string;

  constructor(private rxStompService: RxStompService) {  }

  setupSocketConnection(eventName : string) {
    this.eventName = eventName;

    this.rxStompService.activate();
    this.rxStompService.watch(this.eventName).subscribe((message: any) => {
      this.onMessageReceived(message.body)
    });
  }

  onMessageReceived(message) {
    this.msgReceived.emit(message)
  }

  disconnect() {
    this.rxStompService.deactivate();
  }

  sendMessage(userName: string, msgStr: string) {
    this.rxStompService.publish({
      destination: this.eventName,
      body: JSON.stringify({user: userName, content: msgStr})
    });
  }
}