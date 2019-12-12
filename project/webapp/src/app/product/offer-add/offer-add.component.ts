import { Component, OnInit } from '@angular/core';

import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { FormGroup, Validators, FormControl } from '@angular/forms';


@Component({
  selector: 'app-offer-add',
  templateUrl: './offer-add.component.html',
  styleUrls: ['./offer-add.component.css']
})
export class OfferAddComponent implements OnInit {
  private offerForm:FormGroup;
  private currentDate: string;
  code: any;
  offerStatus : boolean;
  error: string;
  constructor(private datePipe: DatePipe, private productService: ProductService, private router: Router) { }

  ngOnInit() {
    this.offerStatus = false;
    this.error = '';
    this.currentDate = this.datePipe.transform(new Date() , 'dd/MM/yyyy');
    this.offerForm = new FormGroup({
      'id': new FormControl(0, [Validators.required]),
      'offerDate': new FormControl(this.currentDate, [Validators.required]),
      'productCode': new FormControl('', [Validators.required]),
      'discountPercent': new FormControl('0', [Validators.required])
    });
    this.productService.getAllProducts().subscribe((response) => {
      console.log(response);
      this.code = response;
    });
  }

  onAddToOffer(offerForm){
    console.log(offerForm.value);
    this.productService.addOffers(offerForm.value).subscribe((response) =>{
    },
    (responseError) => {
      this.offerStatus = false;
      this.error = "offer already exists";
    })
  }

  onEditOffer(){
    this.router.navigate(['update-offer']);
  }
}
