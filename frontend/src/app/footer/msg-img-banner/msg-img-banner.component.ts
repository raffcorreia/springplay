import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";
import {BannerMessage} from "../banner.message";

@Component({
  selector: 'app-msg-img-banner',
  templateUrl: './msg-img-banner.component.html',
  styleUrls: ['./msg-img-banner.component.sass']
})
export class MsgImgBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.MSG_IMG;
  message: BannerMessage;
  base64Img: string;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: any) {
    this.message = message;
    this.base64Img = atob(message.img);
  }
}
