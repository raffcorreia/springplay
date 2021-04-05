import {Component, OnInit, ViewChild} from '@angular/core';
import {SqlInjectionService} from "../services/sql-injection.service";
import {LoginComponent} from "../login/login.component";


@Component({
  selector: 'app-sql-injection',
  templateUrl: './sql-injection.component.html',
  styleUrls: ['./sql-injection.component.sass']
})
export class SqlInjectionComponent implements OnInit {
  defaultUserName: string = 'test \' AND 1=1; --';
  defaultPassword: string = 'WRONG_PASSWORD';

  @ViewChild('loginJPA') loginJPA: LoginComponent;
  @ViewChild('loginJDBC') loginJDBC: LoginComponent;

  constructor(
      private sqlInjectionService: SqlInjectionService
  ) { }

  ngOnInit() {
  }

  processLoginResult(result: { authenticated: boolean }, loginComponent: LoginComponent) {
      console.log("IsAuthenticated = " + result.authenticated);
      loginComponent.loginResult(result.authenticated);
  }

  submitLoginJPA($event: { userName: string; password: string }){
    console.log('sql-inj-component submitting...');
    return this.sqlInjectionService.loginUsingJPA($event.userName, $event.password)
        .subscribe(
            data => {
                this.processLoginResult(data, this.loginJPA);
            },
            error => {
                console.log("ERROR!");
                this.processLoginResult({ authenticated: false }, this.loginJPA);
            });
  }

    submitLoginJDBC($event: { userName: string; password: string }){
        console.log('sql-inj-component submitting...');
        return this.sqlInjectionService.loginUsingJDBC($event.userName, $event.password)
            .subscribe(
                data => {
                    this.processLoginResult(data, this.loginJDBC);
                },
                error => {
                    console.log("ERROR!");
                    this.processLoginResult({ authenticated: false }, this.loginJDBC);
                });
    }
}
