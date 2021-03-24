import { Injectable } from '@angular/core';
import {Xss} from './xss';
import {Observable, of} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class XssService {

  private readonly GET_XSS_URL: string = '/xss/getXSS';
  private readonly POST_XSS_URL: string = '/xss/postXSS';
  private readonly PUT_XSS_URL: string = '/xss/putXSS';
  private readonly DEL_XSS_URL: string = '/xss/delXSS';

  constructor(private http: HttpClient) {
  }

  getXssList(): Observable<Xss[]> {
    return this.http.get<Xss[]>(this.GET_XSS_URL);
  }

  getXssById(id: number) {
    const url = this.GET_XSS_URL + '/' + id;
    return this.http.get<Xss>(url);
  }

  postXss(xss: string) {
    return this.http.post<Xss>(this.POST_XSS_URL, {text: xss});
  }

  putXss(currentid: number, text: string) {
    return this.http.put<Xss>(this.PUT_XSS_URL, {id: currentid, text: text});
  }

  delXss(id: number) {
    const url = this.DEL_XSS_URL + '/' + id;
    return this.http.delete<Xss>(url);
  }
}
