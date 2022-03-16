import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";
import {BannerMessage} from "../banner.message";

@Component({
  selector: 'app-error-banner',
  templateUrl: './error-banner.component.html',
  styleUrls: ['./error-banner.component.sass']
})
export class ErrorBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.ERROR;
  message: BannerMessage;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: BannerMessage) {
    this.message = message;
  }
}
