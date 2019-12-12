import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { AuthenticationService } from 'src/app/registration/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  status:boolean;
  productList: any;
  filterProduct: any;
  firstName: string;
  addToPurchaseListStatus: boolean;
  productCode : number;
  userType: string;
  offerProducts:any = [];
  offerCodes : any = [];
 
  constructor(private productService: ProductService, private authenticationService: AuthenticationService, private router: Router) { }

  ngOnInit() {
    this.firstName = this.authenticationService.getFirstName();
    this.status = true;
    this.addToPurchaseListStatus = false;
    this.userType = this.authenticationService.getUserType();
    this.productService.getAllProducts().subscribe((response) => {
      console.log(response);
      this.productList = response;
      this.filterProduct = response;
      console.log(this.productList);
    })

    this.productService.getCurrentDateOffers().subscribe((response) => {
      console.log(response);
      this.offerProducts = response;
      for(let i=0;i<this.offerProducts.length; i++){
        this.offerCodes[i] = this.offerProducts[i].productCode;
      }
      console.log(this.offerCodes);
    })  
  
  }

  updateProductList(){
    this.productService.getAllProducts().subscribe((response) => {
      console.log(response);
      this.productList = response;
      this.filterProduct = response;
      console.log(this.productList);
    })
  }

  filterItems($event) {
    this.filterProduct = this.productService.getFilteredProducts($event, this.productList);
  }

    sortByAvailability(){
      this.productService.sortByAvailability().subscribe((response) => {
        this.filterProduct = response;
      })
    }

    sortByName(){
      this.productService.sortByName().subscribe((response) => {
        this.filterProduct = response;
      })
    }

    sortByPrice(){
      this.productService.sortByPrice().subscribe((response) => {
        this.filterProduct = response;
      })
    }

    sortByPopularity(){
      this.productService.sortByPopularity().subscribe((response) => {
        this.filterProduct = response;
      })
    }

    addToPurchaseList(code){
      this.addToPurchaseListStatus = true;
      this.productCode = code;
    }

    editProductClick(code){
      this.router.navigate(['edit-product', code]);
    }

    deleteProductClick(code){
      this.productService.deleteProduct(code).subscribe((response) =>{
        this.updateProductList();
      });
    }

 
}
