import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";
import {BannerMessage} from "../banner.message";

@Component({
  selector: 'app-qabanner',
  templateUrl: './qabanner.component.html',
  styleUrls: ['./qabanner.component.sass']
})
export class QABannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.QA;
  message: BannerMessage;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: BannerMessage) {
    this.message = message;
  }
}
