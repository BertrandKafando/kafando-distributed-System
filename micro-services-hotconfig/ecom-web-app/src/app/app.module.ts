import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { CustomerComponent } from './main/customer/customer.component';
import { ProductComponent } from './main/product/product.component';
import { OrderComponent } from './main/order/order.component';
import {NavbarComponent} from "./layouts/navbar/navbar.component";
import {ProductService} from "./main/product/service/products.service";
import {HttpClientModule} from "@angular/common/http";
import { OrderDetailsComponent } from './main/order/component/order-details/order-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    CustomerComponent,
    ProductComponent,
    OrderComponent,
    OrderDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
