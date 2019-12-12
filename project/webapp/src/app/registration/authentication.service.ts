import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private authenticationApiUrl ='http://localhost:8083/authentication-service/smart-shop/authenticate';
  state: boolean;
  token: string;
  userType: string;
  status: string;
  firstName: string;
  userId: string;

  constructor(private httpClient: HttpClient) { }

  authenticate(user: string, password: string) {
    let credentials = btoa(user + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials);
    return this.httpClient.get(this.authenticationApiUrl, { headers });
  }

  login() {
    this.state = true;
  }

  logout() {
    this.state = false;
  }

  loggedInUser() {
    return this.state;
  }
  public setToken(token: string) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }
  
  public setUserType(userType: string) {
    this.userType = userType;
  }
  public getUserType() {
    return this.userType;
  }
  
  public setUserId(userId: string) {
    this.userId = userId;
  }
  public getUserId() {
    return this.userId;
  }
  
  public setStatus(status: string) {
    this.status = status;
  }
  public getStatus() {
    return this.status;
  }

  public setFirstName(firstName: string) {
    this.firstName = firstName;
  }
  public getFirstName() {
    return this.firstName;
  }
}
