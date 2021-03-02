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
  }

}
