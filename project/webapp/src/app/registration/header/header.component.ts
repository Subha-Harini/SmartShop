import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }
  firstName: string;
  loginStatus: boolean;
  userType: string;

  ngOnInit() {
    this.firstName = null;
    this.loginStatus = this.authenticationService.loggedInUser();
    this.userType = null;
  }

  getFirstName(){
    this.firstName = this.authenticationService.getFirstName();
    return this.authenticationService.getFirstName();
  }

  getUserType(){
    this.userType = this.authenticationService.getUserType();
    return this.userType;
  }

  logout(){
    this.authenticationService.logout();
    this.authenticationService.setUserType("");
    this.authenticationService.setFirstName("");
    this.authenticationService.setStatus("");
    this.authenticationService.setToken("");
    this.router.navigate(['home']);
  }
  login(){
    this.router.navigate(['login']);
  }

  requests(){
    this.router.navigate(['register-approval-list']);
  }

  addProduct(){
    this.router.navigate(['add-product']);
  }

  addBill(){
    this.router.navigate(['add-bill']);
  }

  purchaseHistory(){
    this.router.navigate(['purchase-history']);
  }
  getProducts(){
    this.router.navigate(['product-list']);
  }

  updateOffer(){
    this.router.navigate(['add-offer']);
  }
}
