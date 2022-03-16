import { Component, OnInit } from '@angular/core';
import {BannerType} from "../banner.type";
import {BannerMessage} from "../banner.message";

@Component({
  selector: 'app-motivational-banner',
  templateUrl: './motivational-banner.component.html',
  styleUrls: ['./motivational-banner.component.sass']
})
export class MotivationalBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.MOTIVATIONAL;
  message: BannerMessage;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: BannerMessage) {
    this.message = message;
  }
}
