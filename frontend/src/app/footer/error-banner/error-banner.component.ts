import {Component, OnInit} from '@angular/core';
import {BannerType} from "../banner.type";

@Component({
  selector: 'app-error-banner',
  templateUrl: './error-banner.component.html',
  styleUrls: ['./error-banner.component.sass']
})
export class ErrorBannerComponent implements OnInit {
  public static TYPE: BannerType = BannerType.ERROR;

  constructor() { }

  ngOnInit(): void {
  }

}
