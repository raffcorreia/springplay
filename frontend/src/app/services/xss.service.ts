import { Injectable } from '@angular/core';
import {Xss} from './xss';
import {Observable, of} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class XssService {

  private readonly getXSSUrl: string = '/getXSS';
  private readonly postXSSUrl: string = '/postXSS';

  constructor(private http: HttpClient) {
  }

  getXssList(): Observable<Xss[]> {
    return this.http.get<Xss[]>(this.getXSSUrl);
  }

  getXssById(id: number) {
    const url = this.getXSSUrl + '/' + id;
    return this.http.get<Xss>(url);
  }

  postXss(txtBox: string) {
    console.log(txtBox);
    return this.http.post<Xss>(this.postXSSUrl, {text: txtBox});
  }
}
