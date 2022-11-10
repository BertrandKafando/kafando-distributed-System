import { Component, OnInit } from '@angular/core';
import {Customer} from "./model/customer.model";
import {CustomerService} from "./service/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  customers: Customer[] = [];
  constructor(private Service: CustomerService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAll() ;
  }

  getAll() {
    this.Service.getAll().subscribe(
      {
        next:  (data) => {
          this.customers = data._embedded.customers;
          console.log(data);
        },
        error: (error) => {
          console.error(error) ;
        }
      }
    );
  }

  getOrders(c: Customer) {
    this.router.navigateByUrl("/orders/"+c.id);
  }
}
