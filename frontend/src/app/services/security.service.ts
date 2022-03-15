import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserDetails} from "./user-details";
import {share} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  private readonly GET_USER_DETAILS: string = "/userDetails";

  userDetails: Promise<UserDetails>;

  constructor(private http: HttpClient) { }

  getUserDetails(): Promise<UserDetails> {
    console.log('getUserDetails(...)');
    console.log(this.userDetails);
    console.log(!this.userDetails);

    if(!this.userDetails) {
      console.log('It is going to retrieve User Details...');

      this.userDetails = this.http.get<UserDetails>(this.GET_USER_DETAILS).pipe(share()).toPromise();
    }

    return this.userDetails;
  }
}
