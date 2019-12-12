import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/registration/authentication.service';
import { BillService } from '../bill.service';
import { UserService } from 'src/app/registration/user.service';
import { ProductDetails, ProductDetailsPojo } from '../productDetails';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-purchase-history',
  templateUrl: './purchase-history.component.html',
  styleUrls: ['./purchase-history.component.css']
})
export class PurchaseHistoryComponent implements OnInit {
  userId: string;
  bills: any;
  billId: number;
  total:number;
  discountedTotal: number;
  reward:number;
  totalRewardPoints: number = 0;
  isGetDetailsClicked: boolean;
  products: ProductDetails[] = [];
  date: Date;
  
  constructor(private authenticationService: AuthenticationService,private router:Router, private billService: BillService, private userService:UserService, private productService:ProductService) { }

  ngOnInit() {
    this.userId = this.authenticationService.getUserId();
    this.userService.getUser(this.userId).subscribe((response) => {
        this.billService.getUserBills(response['id']).subscribe((response) => {
         this.bills = response;
         if(this.bills != null){
           for(let i =0; i<this.bills.length; i++){
             this.totalRewardPoints += this.bills[i].rewardPoints;
           }
         }
       })

    })

  }

  getDetails(billDetailsList: any[],billId: number ,total: number ,reward : number, discountedTotal: number, purchaseDate : Date){
    console.log(reward);
    this.total = total;
    this.reward = reward;
    this.discountedTotal = discountedTotal;
    this.billId = billId;
    this.date = purchaseDate;
    this.isGetDetailsClicked = true;
    for(let i=0; i < billDetailsList.length; i++){
      this.productService.getProduct(billDetailsList[i].productId).subscribe((response)=>{
        console.log(response);
        this.products.push({ratePerQuantity: response['ratePerQuantity'], productName: response['name'], productCode: response['code'], quantity: billDetailsList[i].quantity});
      });
    }
      console.log(this.products);
          
  }

  back(){
    this.isGetDetailsClicked = false;
    this.products = [];
  }

}
