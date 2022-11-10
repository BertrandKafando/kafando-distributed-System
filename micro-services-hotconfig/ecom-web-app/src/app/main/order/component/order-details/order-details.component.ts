import { Component, OnInit } from '@angular/core';
import {OrderService} from "../../service/order.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  orderDetails :any;
  orderId!:number;
  constructor(private service: OrderService , private router: Router, private route:ActivatedRoute) {

  }


  ngOnInit(): void {
    this.orderId = this.route.snapshot.params['id'];
    this.service.getOrder(this.orderId)
      .subscribe({
        next : (data)=>{
          this.orderDetails=data;
        },
        error : (err)=>{}
      });
  }

}
