import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControlName, FormControl, Validators } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
 
  signupForm: FormGroup;
  userCreated: boolean = false;
  error:string;
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.error = '';
    this.userCreated = false;
    this.signupForm = new FormGroup({
      'firstName': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
      'lastName': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(2)]),
      'age': new FormControl("", [Validators.required, Validators.maxLength(2), Validators.pattern("^[0-9]*$")]),
      'gender': new FormControl("", [Validators.required]),
      'contactNumber': new FormControl("", [Validators.required, Validators.maxLength(10), Validators.minLength(10), Validators.pattern("^[0-9]*$")]),
      'userId': new FormControl("", [Validators.required, Validators.maxLength(15), Validators.minLength(6)]),
      'password': new FormControl("", [Validators.required, Validators.maxLength(15), Validators.minLength(6)]),
      'userType': new FormControl("", [Validators.required, Validators.maxLength(1)]),
      'secretQuestionOne': new FormControl("", [Validators.required]),
      'secretAnswerOne': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(3)]),
      'secretQuestionTwo': new FormControl("", [Validators.required]),
      'secretAnswerTwo': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(3)]),
      'secretQuestionThree': new FormControl("", [Validators.required]),
      'secretAnswerThree': new FormControl("", [Validators.required, Validators.maxLength(50), Validators.minLength(3)])
    });
  }

  onSubmit(signupForm){
    console.log(signupForm.value)
    this.userService.register(signupForm.value).subscribe((response)=>{
      this.userCreated = true;
    }, (responseError) => {
      this.error = responseError.error.errorMessage;
    });
  }
  login(){
    this.router.navigate(['login']);
  }

}

