import {EventEmitter, Injectable, Output} from '@angular/core';
import {Observable, Subscription} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class StompClientService {

  @Output() public msgReceived = new EventEmitter();

  constructor() {  }

  setupSocketConnection(eventName : string) {
  }

  onMessageReceived(message: any) {
  }

  disconnect() {
  }

  sendMessage(msgObj: {message, roomName}) {
  }
}