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
  strQuestion: string;
  strAnswer: string;

  constructor() { }

  ngOnInit(): void {
  }

  public setMessage(message: any) {
    this.strQuestion = message.question;
    this.strAnswer = message.answer;
  }
}
