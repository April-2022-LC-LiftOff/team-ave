// import { Component, OnInit } from '@angular/core';
// import { Router } from '@angular/router';
// import { RegistrationService } from '../service/registration.service';

// import { User } from '../user';


// @Component({
//   selector: 'app-registration',
//   templateUrl: './registration.component.html',
//   styleUrls: ['./registration.component.css']
// })
// export class RegistrationComponent implements OnInit {
//   user = new User();
//   msg='';

//   constructor(private _service : RegistrationService, private _route : Router) { }

//   ngOnInit(): void {
//   }

//   registerUser() {
//     this._service.registerUserFromRemote(this.user).subscribe(
//       data => {
//         console.log("success");
//         this._route.navigate([''])
//       },
//       error => {
//         console.log("error processing registration");
//         this.msg=error.error;
//       }
//     )
//   }
// }

import { Component, OnInit } from '@angular/core';
import { AuthService } from '../_services/auth.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {
  form: any = {
    username: null,
    email: null,
    password: null
  };

  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) { }
  ngOnInit(): void {
  }

  onSubmit(): void {
    const { username, email, password } = this.form;
    this.authService.register(username, email, password).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}