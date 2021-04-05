import {Component, OnInit} from '@angular/core';
import {SqlInjectionService} from "../services/sql-injection.service";


@Component({
  selector: 'app-sql-injection',
  templateUrl: './sql-injection.component.html',
  styleUrls: ['./sql-injection.component.sass']
})
export class SqlInjectionComponent implements OnInit {
  defaultUserName: string = 'test \' AND 1=1; --';
  defaultPassword: string = 'WRONG_PASSWORD';
  jpaLoginSuccessful: boolean = null;
  jdbcLoginSuccessful: boolean = null;

  constructor(
      private sqlInjectionService: SqlInjectionService
  ) { }

  ngOnInit() {
  }

  submitLoginJPA($event: { userName: string; password: string }){
    console.log('sql-inj-component submitting...');
    return this.sqlInjectionService.loginUsingJPA($event.userName, $event.password)
        .subscribe(
            data => {
              this.jpaLoginSuccessful = data.authenticated;
              if(data.authenticated) {
                console.log("OK!")
              } else {
                console.log("Login Failure!")
              }
            },
            error => {
              this.jpaLoginSuccessful = false;
              console.log("ERROR!")
            });
  }

    submitLoginJDBC($event: { userName: string; password: string }){
        console.log('sql-inj-component submitting...');
        return this.sqlInjectionService.loginUsingJDBC($event.userName, $event.password)
            .subscribe(
                data => {
                    this.jdbcLoginSuccessful = data.authenticated;
                    if(data.authenticated) {
                        console.log("OK!")
                    } else {
                        console.log("Login Failure!")
                    }
                },
                error => {
                    this.jdbcLoginSuccessful = false;
                    console.log("ERROR!")
                });
    }
}
