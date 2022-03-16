import { Component, OnInit } from '@angular/core';
import {BannerType} from "../banner.type";

@Component({
  selector: 'app-motivational-banner',
  templateUrl: './motivational-banner.component.html',
  styleUrls: ['./motivational-banner.component.sass']
})
export class MotivationalBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.MOTIVATIONAL;

  constructor() { }

  ngOnInit(): void {
  }

}
