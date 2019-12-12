import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  users: any;
  loginForm: FormGroup;
  error: string;
  isLoggedIn: boolean;
  loginStatus: boolean;

  constructor( private route: Router, private authenticationService: AuthenticationService) { }

  ngOnInit() {
  
    this.loginStatus = true;
    this.isLoggedIn = true;
  
    this.loginForm = new FormGroup({
      'userId': new FormControl('', [Validators.required]
      ),
      'passwrd': new FormControl('', [Validators.required]
      )
    });
  }

  onSubmit(loginForm) {
    console.log(loginForm.value);
    
     this.authenticationService.authenticate(loginForm.value.userId, loginForm.value.passwrd).subscribe((response) => {
       console.log(response);
      if(response['status'] == 'A'){
          this.loginStatus = true;
          this.authenticationService.login();
          this.authenticationService.setToken(response['token']);
          console.log(loginForm.value.userId);
          this.authenticationService.setUserId(loginForm.value.userId);
          console.log(this.authenticationService.getUserId());
          console.log(this.authenticationService.getToken());
          this.authenticationService.setStatus(response['status']);
          this.authenticationService.setUserType(response['userType']);
          this.authenticationService.setFirstName(response['firstName']);
          this.route.navigate(['product-list']);
      }
      else if(response['status'] == 'P'){
        this.loginStatus = false;
        this.error = "Approval is pending";
      }
      else if(response['status'] == 'D'){
        this.loginStatus = false;
        this.error = "User declined";
      }
    },
      (error) => {
        this.loginStatus = false;
        this.error = "Invalid username/password";
      });
  }

  forgetUserId(){
    this.route.navigate(['forget-id-password','id']);
  }

  forgetPassword(){
    this.route.navigate(['forget-id-password','password']);
  }

}
