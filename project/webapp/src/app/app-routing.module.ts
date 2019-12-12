import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistrationComponent } from './registration/registration/registration.component';
import { HeaderComponent } from './registration/header/header.component';
import { HomeComponent } from './home/home/home.component';
import { LoginComponent } from './registration/login/login.component';
import { ProductListComponent } from './product/product-list/product-list.component';
import { LoginGuard } from './registration/login.guard';
import { RegisterApprovalComponent } from './registration/register-approval/register-approval.component';
import { AddProductComponent } from './product/add-product/add-product.component';
import { EditProductComponent } from './product/edit-product/edit-product.component';
import { EditSuccessComponent } from './product/edit-success/edit-success.component';
import { BillComponent } from './product/bill/bill.component';
import { PurchaseHistoryComponent } from './product/purchase-history/purchase-history.component';
import { UpdateOfferComponent } from './product/update-offer/update-offer.component';
import { OfferAddComponent } from './product/offer-add/offer-add.component';
import { OfferInfoComponent } from './product/offer-info/offer-info.component';
import { ForgotPasswordComponent } from './registration/forgot-password/forgot-password.component';



const routes: Routes = [
  { path: '', component:HomeComponent},
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'header', component: HeaderComponent },
  { path: 'login', component: LoginComponent},
  { path: 'register/login', component: LoginComponent },
  { path: 'product-list', component:  ProductListComponent, canActivate:[LoginGuard] },
  { path: 'register-approval-list', component:  RegisterApprovalComponent, canActivate:[LoginGuard] },
  {path: 'add-product', component: AddProductComponent, canActivate:[LoginGuard]  },
  {path: 'edit-product/:code', component: EditProductComponent, canActivate:[LoginGuard]  },
  {path: 'edit-success', component: EditSuccessComponent, canActivate:[LoginGuard]  },
  {path: 'add-bill', component: BillComponent,canActivate:[LoginGuard]  },
  {path: 'drop-bill', component: BillComponent,canActivate:[LoginGuard]  },
  {path: 'purchase-history', component: PurchaseHistoryComponent,canActivate:[LoginGuard]  },
  {path: 'update-offer', component: UpdateOfferComponent,canActivate:[LoginGuard]  },
  {path: 'add-offer', component: OfferAddComponent,canActivate:[LoginGuard]  },
  {path: 'offer-info/:id', component: OfferInfoComponent,canActivate:[LoginGuard]  },
  {path: 'forget-id-password/:forgot', component:  ForgotPasswordComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
