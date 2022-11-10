import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OrderService} from "./service/order.service";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orders :any;
  customerId!:number;
  constructor(private service: OrderService,
    private router: Router,
    private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.customerId = this.route.snapshot.params['id'];
    this.service.getbyCustomer(this.customerId)
      .subscribe({
        next : (data)=>{
          this.orders=data._embedded.orders;
        },
        error : (err)=>{}
      });
  }

  getOrderDetails(o: any) {
    this.router.navigateByUrl("/order-details/"+o.id);
  }
}
