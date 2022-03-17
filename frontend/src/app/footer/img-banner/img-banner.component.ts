import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";
import FooterUtils from "../footer-utils";


@Component({
  selector: 'app-img-banner',
  templateUrl: './img-banner.component.html',
  styleUrls: ['./img-banner.component.sass']
})
export class ImgBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.IMG;
  base64ImgData: any;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: any) {
    if(message) {
      this.base64ImgData = FooterUtils.buildImageSrcData(message.imgType, message.wideImg);
    }
  }
}
