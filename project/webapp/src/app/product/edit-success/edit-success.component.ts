import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-success',
  templateUrl: './edit-success.component.html',
  styleUrls: ['./edit-success.component.css']
})
export class EditSuccessComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit() {
  }
  viewProduct(){
    this.route.navigate(['product-list']);
  }
}
