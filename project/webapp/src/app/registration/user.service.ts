import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }

  register(registrationForm){
    let status = "P";
    if(registrationForm.userType == "U"){
        status = "A";
      }
    let body = {
                firstName: registrationForm.firstName,
                lastName: registrationForm.lastName,
                age: registrationForm.age,
                gender: registrationForm.gender,
                contactNumber: registrationForm.contactNumber,
                userId: registrationForm.userId,
                password: registrationForm.password,
                userType: registrationForm.userType,
                status: status,
                secretQuestionOne: registrationForm.secretQuestionOne,
                secretAnswerOne: registrationForm.secretAnswerOne,
                secretQuestionTwo: registrationForm.secretQuestionTwo,
                secretAnswerTwo: registrationForm.secretAnswerTwo,
                secretQuestionThree: registrationForm.secretQuestionThree,
                secretAnswerThree: registrationForm.secretAnswerThree,
    };
    console.log(body);
    return this.httpClient.post<any>("http://localhost:8083/signup-service/smart-shop/users", body);

  }
  
  getAllPendingRequests(){
   
    return this.httpClient.get("http://localhost:8083/signup-service/smart-shop/users/pending-users");
  }

  approveUser(id){
    console.log(id);
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.put("http://localhost:8083/signup-service/smart-shop/users/pending-users/approve/"+id,"",  httpOptions);
  }

  declineUser(id){
    console.log(id);
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.put("http://localhost:8083/signup-service/smart-shop/users/pending-users/decline/"+id,"",  httpOptions);
  }

  getUser(userId){
    
    return this.httpClient.get("http://localhost:8083/signup-service/smart-shop/users/" + userId);
  }

  getUserByContact(contact){
    
    return this.httpClient.get("http://localhost:8083/signup-service/smart-shop/users/contact/" + contact);
  }

  updateUserWithNewPassword(registrationForm){
    console.log(registrationForm);
    let body = {
      id: registrationForm.id,
      firstName: registrationForm.firstName,
      lastName: registrationForm.lastName,
      age: registrationForm.age,
      gender: registrationForm.gender,
      contactNumber: registrationForm.contactNumber,
      userId: registrationForm.userId,
      password: registrationForm.password,
      userType: registrationForm.userType,
      status: status,
      secretQuestionOne: registrationForm.secretQuestionOne,
      secretAnswerOne: registrationForm.secretAnswerOne,
      secretQuestionTwo: registrationForm.secretQuestionTwo,
      secretAnswerTwo: registrationForm.secretAnswerTwo,
      secretQuestionThree: registrationForm.secretQuestionThree,
      secretAnswerThree: registrationForm.secretAnswerThree,
    };
    return this.httpClient.put("http://localhost:8083/signup-service/smart-shop/users/new-password", body);
  }
  
  

}
