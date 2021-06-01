
  
  import { Component, OnInit } from '@angular/core';
  import { FormGroup, FormControl, Validators } from '@angular/forms';
  import { DatePipe } from '@angular/common';
  import { ProductService } from '../product.service';
  import { ProductDetails, ProductDetailsPojo } from '../productDetails';
  import { BillService } from '../bill.service';
  import { Router } from '@angular/router';
  
  @Component({
    selector: 'app-bill',
    templateUrl: './bill.component.html',
    styleUrls: ['./bill.component.css']
  })
  export class BillComponent implements OnInit {
    private billForm:FormGroup;
    private currentDate: string;
    private userId: number;
    private customers: any;
    private discountedTotal: any;
    date: Date;
    isDeleted: boolean;
    total: number;
    rewardPoints: number;
    code: any;
    productDetails: ProductDetails[] = [];
    isBillGenerated: boolean;
    isProductAdded: boolean;
    productListHasCode : boolean;
    error: string;
   
    constructor(private datePipe: DatePipe, private billService:BillService, private productService: ProductService, private router:Router) { }
  
    ngOnInit() {
      this.error = null;
      this.isBillGenerated = false;
      this.isProductAdded = false;
      this.isDeleted = false;
      this.total = 0;
      this.discountedTotal = 0;
      this.rewardPoints = 0;
      this.currentDate = this.datePipe.transform(new Date() , 'dd/MM/yyyy');
      this.productService.getAllProducts().subscribe((response) => {
        console.log(response);
        this.code = response;
      });
      this.billService.getCustomers().subscribe((response) => {
        //console.log(response);
        this.customers = response;
        console.log(this.customers)
      })
      this.billForm = new FormGroup({
        'userId': new FormControl("", [Validators.required]),
        'purchaseDate': new FormControl(this.currentDate, [Validators.required]),
        'productCode': new FormControl('', [Validators.required]),
        'quantity': new FormControl('0', [Validators.required]),
      });
  
     
    }
    onAddToBill(billForm){
      console.log(billForm.value);
      this.isProductAdded = true;
       this.userId = billForm.value.userId; 
      this.productListHasCode = false;
      for(let i=0; i<this.productDetails.length ; i++){
        if(this.productDetails[i].productCode == billForm.value.productCode ){
          this.productListHasCode = true;
        }
      }
      if(!this.productListHasCode){
      this.productService.getProduct(billForm.value.productCode).subscribe((response) => {
        console.log(response);
        this.productDetails.push({ratePerQuantity: response['ratePerQuantity'], productName: response['name'], productCode: billForm.value.productCode, quantity: billForm.value.quantity})
      })
    }
      console.log(this.productDetails);
    }

    onGenerateBill(billForm){
      console.log(billForm.value)
       this.billService.generateBill(billForm.value, this.productDetails).subscribe((response) => {
        this.isBillGenerated = true;
        this.total = response['totalAmount'] ;
        this.discountedTotal = response['discountedTotal'];
        this.rewardPoints = response['rewardPoints'];
        this.date = response['purchaseDate'];
      },(error)=>{
          this.error = "You added an expired Product";
      }); 
    }
    onDropBill(billForm){
      this.productDetails = [];
      console.log(this.productDetails);
      this.router.navigate(['drop-bill']);
    }
    deleteProduct(product:ProductDetails){
      let index = this.productDetails.indexOf(product);
      this.productDetails.splice(index, 1);
      this.isDeleted = true;
    }
  
  }