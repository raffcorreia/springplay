import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";
import {BannerMessage} from "../banner.message";

@Component({
  selector: 'app-img-banner',
  templateUrl: './img-banner.component.html',
  styleUrls: ['./img-banner.component.sass']
})
export class ImgBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.IMG;
  base64Img: any;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: any) {
    this.base64Img = atob(message.wideImg);
  }
}
