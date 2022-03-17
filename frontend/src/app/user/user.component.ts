import {Component, OnInit} from '@angular/core';
import {SecurityService} from "../services/security.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.sass']
})
export class UserComponent implements OnInit {
  userName: any;

  constructor(private securityService: SecurityService) { }

  ngOnInit(): void {
    this.securityService.getUserDetails().then(
      data => {
        this.userName = data.name;
      },
      error => {
        console.log("ERROR retrieving user details!");
        this.userName = null;
      }
    );
  }
}
