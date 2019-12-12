import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { RegistrationComponent } from './registration/registration/registration.component';
import { HeaderComponent } from './registration/header/header.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './registration/login/login.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { SearchComponent } from './product/search/search.component';
import { RegisterApprovalComponent } from './registration/register-approval/register-approval.component';
import { EditProductComponent } from './product/edit-product/edit-product.component';
import { AddProductComponent } from './product/add-product/add-product.component';
import { DatePipe } from '@angular/common';
import { EditSuccessComponent } from './product/edit-success/edit-success.component';
import { BillComponent } from './product/bill/bill.component';
import { PurchaseHistoryComponent } from './product/purchase-history/purchase-history.component';
import { UpdateOfferComponent } from './product/update-offer/update-offer.component';
import { OfferAddComponent } from './product/offer-add/offer-add.component';
import { OfferInfoComponent } from './product/offer-info/offer-info.component';
import { ForgotPasswordComponent } from './registration/forgot-password/forgot-password.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    ProductListComponent,
    SearchComponent,
    RegisterApprovalComponent,
    EditProductComponent,
    AddProductComponent,
    EditSuccessComponent,
    BillComponent,
    PurchaseHistoryComponent,
    UpdateOfferComponent,
    OfferAddComponent,
    OfferInfoComponent,
    ForgotPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
