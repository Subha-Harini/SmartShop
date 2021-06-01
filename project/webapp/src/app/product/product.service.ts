import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from '../registration/authentication.service';
import { ProductDetails } from './productDetails';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  filterItems: any;

  constructor(private httpClient: HttpClient, private authenticationService: AuthenticationService ) { }

  getAllProducts() {
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/products", httpOptions);
  }

  getProduct(code) {
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    } 
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/products/"+code, httpOptions);
  }


  getFilteredProducts(str, productList) {
    let search = str.toLocaleLowerCase();
    this.filterItems = productList.filter((m: any) => m.name.toLocaleLowerCase().indexOf(search) != -1);
    return this.filterItems;
  }

  sortByAvailability(){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/products/sort-by-availability", httpOptions);
  }
 
  sortByName(){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/products/sort-by-name", httpOptions);
  }

  sortByPrice(){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get(" http://localhost:8083/product-service/smart-shop/products/sort-by-price", httpOptions);
  }

  sortByPopularity(){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/products/sort-by-popularity", httpOptions);
  }

  addProduct(product: any){
    var dateParts = product.addDate.split("/");
    var addDateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0] ); 
    var dateParts =product.dateOfManufacture.split("/");
    var dateOfManufactureObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0] ); 
    var dateParts =product.dateOfExpiry.split("/");
    var dateOfExpiryObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0] ); 
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    let body = {
      code: product.code,
      name: product.name,
      type: product.type,
      brand: product.brand,
      quantityType: product.quantityType,
      ratePerQuantity: product.ratePerQuantity,
      stockCount: product.stockCount,
      addDate: addDateObject,
      aisle: product.aisle,
      shelf: product.shelf,
      dateOfManufacture: dateOfManufactureObject,
      dateOfExpiry: dateOfExpiryObject,
      image: product.image
    };
    return this.httpClient.post("http://localhost:8083/product-service/smart-shop/products", body, httpOptions);
  }
  
  editProduct(product){
    var dateParts =product.addDate.split("/");
    var addDateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    var dateParts =product.dateOfManufacture.split("/");
    var dateOfManufactureObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    var dateParts =product.dateOfExpiry.split("/");
    var dateOfExpiryObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    let body = {
      code: product.code,
      name: product.name,
      type: product.type,
      brand: product.brand,
      quantityType: product.quantityType,
      ratePerQuantity: product.ratePerQuantity,
      stockCount: product.stockCount,
      addDate: addDateObject,
      aisle: product.aisle,
      shelf: product.shelf,
      dateOfManufacture: dateOfManufactureObject,
      dateOfExpiry: dateOfExpiryObject,
      image: product.image
    };
    return this.httpClient.put("http://localhost:8083/product-service/smart-shop/products", body, httpOptions);
  }

  deleteProduct(code){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.delete("http://localhost:8083/product-service/smart-shop/products/"+code, httpOptions);
  }

  getofferByDate(date){
    var dateParts =  date.split("/");
    var dateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    console.log("http://localhost:8083/product-service/smart-shop/offers-by-date/"+dateObject);
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/offers-by-date/"+dateObject, httpOptions);
  }

  getCurrentDateOffers(){
    
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/offers-by-date", httpOptions);
  }


  getOfferByOfferId(id){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.get("http://localhost:8083/product-service/smart-shop/offers/"+id, httpOptions);
  }

  addOffers(offerForm){
    var dateParts =offerForm.offerDate.split("/");
    var dateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    let body =  {
      "id": offerForm.id,
      "offerDate": dateObject ,
      "discountPercent": offerForm.discountPercent,
      "productCode": offerForm.productCode
  }
    return this.httpClient.post("http://localhost:8083/product-service/smart-shop/offers",body, httpOptions);
  }

  updateOffers(offerForm){
    var dateParts =offerForm.offerDate.split("/");
    var dateObject = new Date(+dateParts[2], dateParts[1] -1 , +dateParts[0]); 
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    let body =  {
      "id": offerForm.id,
      "offerDate": dateObject ,
      "discountPercent": offerForm.discountPercent,
      "productCode": offerForm.productCode
  }
    return this.httpClient.put("http://localhost:8083/product-service/smart-shop/offers",body, httpOptions);
  }

  deleteOffer(id){
    let token = 'Bearer ' + this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    }
    return this.httpClient.delete("http://localhost:8083/product-service/smart-shop/offers/"+id, httpOptions);
  }
  
}
