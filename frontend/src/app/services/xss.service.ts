import { Injectable } from '@angular/core';
import {Xss} from './xss';
import {Observable, of} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class XssService {

  private getXSSUrl = '/getXSS';

  constructor(private http: HttpClient) {
  }

  getXssList(): Observable<Xss[]> {
    return this.http.get<Xss[]>(this.getXSSUrl);
  }
}
