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
  text: string;
  base64Img: string;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: any) {
    if(message) {
      this.text = message.text;
      this.base64Img = message.img ? atob(message.img) : "";
    }
  }
}
