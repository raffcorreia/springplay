import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class SqlInjectionService {
    private readonly POST_LOGIN_JPA_URL: string = '/sqlinjection/loginJPA';
    private readonly POST_LOGIN_JDBC_URL: string = '/sqlinjection/loginJDBC';

    constructor(private http: HttpClient) {
    }

    loginUsingJPA(userName: string, password: string) {
        console.log('loginUsingJPA(...)');
        return this.http.post<any>(this.POST_LOGIN_JPA_URL, {name: userName, password: password});
    }

    loginUsingJDBC(userName: string, password: string) {
        return this.http.post<any>(this.POST_LOGIN_JDBC_URL, {name: userName, password: password});
    }
}
