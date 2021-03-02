import { Component, OnInit } from '@angular/core';
import {XssService} from '../services/xss.service';
import {Xss} from '../services/xss';

@Component({
  selector: 'app-xss-experience',
  templateUrl: './xss-experience.component.html',
  styleUrls: ['./xss-experience.component.sass']
})
export class XssExperienceComponent implements OnInit {

  constructor(private xssService: XssService) { }

  xssList: Xss[];

  ngOnInit() {
    this.xssService.getXssList()
      .subscribe(xss => this.xssList = xss);

    // load a standard JS into the HTML
    this.loadScript('assets/httpUtils.js');
  }

  private loadScript(scriptUrl: string) {
    return new Promise((resolve, reject) => {
      const scriptElement = document.createElement('script');
      scriptElement.src = scriptUrl;
      scriptElement.onload = resolve;
      console.log(scriptElement);
      document.body.appendChild(scriptElement);
    });
  }
}
