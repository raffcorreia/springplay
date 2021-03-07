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
  private readonly putXSSUrl: string = '/putXSS';
  private readonly delXSSUrl: string = '/delXSS';

  constructor(private http: HttpClient) {
  }

  getXssList(): Observable<Xss[]> {
    return this.http.get<Xss[]>(this.getXSSUrl);
  }

  getXssById(id: number) {
    const url = this.getXSSUrl + '/' + id;
    return this.http.get<Xss>(url);
  }

  postXss(xss: string) {
    return this.http.post<Xss>(this.postXSSUrl, {text: xss});
  }

  putXss(currentid: number, text: string) {
    return this.http.put<Xss>(this.putXSSUrl, {id: currentid, text: text});
  }

  delXss(id: number) {
    const url = this.delXSSUrl + '/' + id;
    return this.http.delete<Xss>(url);
  }
}
