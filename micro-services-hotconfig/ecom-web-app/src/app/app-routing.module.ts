import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductComponent} from "./main/product/product.component";
import {CustomerComponent} from "./main/customer/customer.component";
import {OrderComponent} from "./main/order/order.component";
import {OrderDetailsComponent} from "./main/order/component/order-details/order-details.component";

const routes: Routes = [
  {path: 'products', component:ProductComponent},
  {path: 'customers', component:CustomerComponent},
  {path: 'orders/:id', component:OrderComponent},
  {path: 'order-details/:id', component:OrderDetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
