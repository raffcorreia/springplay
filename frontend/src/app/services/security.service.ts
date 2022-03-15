import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserDetails} from "./user-details";

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  private readonly GET_USER_DETAILS: string = "/userDetails";

  constructor(private http: HttpClient) { }

  getUserDetails(): Observable<UserDetails> {
    console.log('getUserDetails(...)');
    return this.http.get<UserDetails>(this.GET_USER_DETAILS);
  }
}
