import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";

@Component({
  selector: 'app-msg-img-banner',
  templateUrl: './msg-img-banner.component.html',
  styleUrls: ['./msg-img-banner.component.sass']
})
export class MsgImgBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.MSG_IMG;

  constructor() { }

  ngOnInit(): void {
  }

}
