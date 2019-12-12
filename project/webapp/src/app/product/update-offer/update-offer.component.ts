import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { ProductService } from '../product.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Router } from '@angular/router';

@Component({
  selector: 'app-update-offer',
  templateUrl: './update-offer.component.html',
  styleUrls: ['./update-offer.component.css']
})
export class UpdateOfferComponent implements OnInit {
  updateOfferForm: FormGroup;
  currentDate: string;
  offerList: any =  [];

  constructor(private datePipe: DatePipe, private productService: ProductService, private router: Router) { }

  ngOnInit() {
    this.currentDate = this.datePipe.transform(new Date() , 'dd/MM/yyyy');
    this.updateOfferForm = new FormGroup({
      'offerDate': new FormControl(this.currentDate, [Validators.required, Validators.pattern("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$")]),
    });
  }

  fetchOffer(updateOfferForm){
    this.productService.getofferByDate(updateOfferForm.value.offerDate).subscribe(response =>{
      console.log(response);
      this.offerList = response;
    });
  }
  editOffer(id){
    this.router.navigate(['offer-info',id]);
  }
  deleteOffer(id){
    this.productService.deleteOffer(id).subscribe((response) => {
      this.fetchOffer(this.updateOfferForm);
    })
  }
}
