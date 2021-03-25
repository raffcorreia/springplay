import { Component, OnInit } from '@angular/core';
import {XssService} from '../services/xss.service';
import {Xss} from '../services/xss';

@Component({
  selector: 'app-xss-experience',
  templateUrl: './xss-experience.component.html',
  styleUrls: ['./xss-experience.component.sass']
})
export class XssExperienceComponent implements OnInit {
  xssList: Xss[];
  selectedXssText: string;
  txtBox = '';
  txtId: number = null;

  constructor(private xssService: XssService) { }


  ngOnInit() {
    this.updateXssList();

    // load a standard JS into the HTML
    this.loadScript('assets/httpUtils.js');
  }

  private updateXssList() {
    this.xssService.getXssList()
      .subscribe(xss => this.xssList = xss);
  }

  customTrackBy(index: number, obj: any): any {
    // console.log(index);
    // console.log(obj);
    return index;
  }

  private loadScript(scriptUrl: string) {
    if(!this.scriptExists(scriptUrl)) {
      return new Promise((resolve, reject) => {
        const scriptElement = document.createElement('script');
        scriptElement.src = scriptUrl;
        scriptElement.onload = resolve;
        document.body.appendChild(scriptElement);
      });
    }
  }

  private scriptExists(url): boolean {
    return document.querySelector(`script[src="${url}"]`) !== null;
  }

  xssSelectionChanged(id: number) {
    this.txtId = id;
    this.xssService.getXssById(id)
      .subscribe(xss => this.loadForm(xss));
  }

  saveXssEntry() {
    if (this.txtId === null) {
      this.xssService.postXss(this.txtBox)
        .subscribe(xss => this.loadAndRefreshForm(xss));
    } else {
      this.xssService.putXss(this.txtId, this.txtBox )
        .subscribe(xss => this.loadAndRefreshForm(xss));
    }
  }

  delXssEntry() {
    console.log(this.txtId);
    if (this.txtId !== null) {
      this.xssService.delXss(this.txtId).subscribe(() => {this.updateXssList(); } );
    }
  }

  loadForm(xss: Xss) {
    this.selectedXssText = xss.text;
    this.txtBox = xss.text;
    this.txtId = xss.id;
  }

  loadAndRefreshForm(xss: Xss) {
    this.loadForm(xss);
    this.updateXssList();
  }
  clearId() {
    this.txtId = null;
  }

  clearALL() {
    this.clearId();
    this.txtBox = '';
  }

  isRadioButtonSelected(id: number) {
    return id == this.txtId;
  }
}
