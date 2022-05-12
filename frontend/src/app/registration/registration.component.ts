import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../service/registration.service';

import { User } from '../user';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  user = new User();
  msg='';

  constructor(private _service : RegistrationService, private _route : Router) { }

  ngOnInit(): void {
  }

  registerUser() {
    this._service.registerUserFromRemote(this.user).subscribe(
      data => {
        console.log("success");
        this._route.navigate([''])
      },
      error => {
        console.log("error");
        this.msg=error.error;
      }
    )
  }
}
