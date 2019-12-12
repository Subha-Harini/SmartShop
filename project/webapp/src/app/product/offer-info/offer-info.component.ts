import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-offer-info',
  templateUrl: './offer-info.component.html',
  styleUrls: ['./offer-info.component.css']
})
export class OfferInfoComponent implements OnInit {

  constructor(private route: ActivatedRoute, private datePipe: DatePipe, private productService: ProductService, private router: Router) {
    this.offerForm = new FormGroup({
      'id': new FormControl(0, [Validators.required]),
      'offerDate': new FormControl('', [Validators.required]),
      'productCode': new FormControl(0, [Validators.required]),
      'discountPercent': new FormControl(0, [Validators.required])
    });
   }
  offer: any;
  offerForm: FormGroup;
  productList:any;
  errorMessage: string;
  errorFlag:boolean;
  date: string;
  code: any;

  ngOnInit() {
    this.errorFlag = false;
   
      this.route.paramMap.subscribe(params => {
      this.productService.getOfferByOfferId(params.get('id')).subscribe((response) => {
        this.date = this.datePipe.transform(response['offerDate'] , 'dd/MM/yyyy');
      this.offerForm = new FormGroup({
        'id': new FormControl(response['id'], [Validators.required]),
        'offerDate': new FormControl(this.date, [Validators.required]),
        'productCode': new FormControl(response['productCode'], [Validators.required]),
        'discountPercent': new FormControl(response['discountPercent'], [Validators.required])
      });
      this.productService.getAllProducts().subscribe((response) => {
        console.log(response);
        this.code = response;
      });
    })
  })
  }

  update(offerForm){
    console.log(offerForm.value);
    this.productService.updateOffers(offerForm.value).subscribe(response=>{
      this.router.navigate(['product-list']);
    }, error =>{
      this.errorMessage = error.error.message;
      this.errorFlag = true;
    });
  }
}
