import { Injectable } from '@angular/core';
import { AuthenticationService } from '../registration/authentication.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { ProductDetails, ProductDetailsPojo } from './productDetails';


@Injectable({
  providedIn: 'root'
})
export class BillService {
  

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService) { }

  generateBill(bill: any, productList: ProductDetails[] ){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    let productDetails: ProductDetailsPojo[] = [];
    for( let i = 0; i < productList.length; i++){
      productDetails.push({productCode: productList[i].productCode,quantity: productList[i].quantity})
    }
    var dateParts = bill.purchaseDate.split("/");
    var dateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    let body = {
      userId: bill.userId,
      purchaseDate: dateObject,
      productList: productDetails,
      billId: 0,
    };
    console.log(body);
    return this.httpClient.post("http://localhost:8083/product-service/smart-shop/bills", body, httpOptions);

  }

  getCustomers(){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/users/customers" , httpOptions);
  }
 
  
  getUserBills(userId){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/user-bills/"+userId , httpOptions);
  }

  getBill(billId){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/bills/"+billId , httpOptions);
  }
}
