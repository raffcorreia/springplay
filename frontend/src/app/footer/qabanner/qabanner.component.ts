import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";

@Component({
  selector: 'app-qabanner',
  templateUrl: './qabanner.component.html',
  styleUrls: ['./qabanner.component.sass']
})
export class QABannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.QA;

  constructor() { }

  ngOnInit(): void {
  }

}
