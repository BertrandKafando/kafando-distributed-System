import { Component, OnInit } from '@angular/core';
import {ProductService} from "./service/products.service";
import {Product} from "./model/product.model";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
   products: Product[] = [];
  constructor(private Service: ProductService) { }

  ngOnInit(): void {
    this.getAll() ;
  }

  getAll() {
    this.Service.getAll().subscribe(
        {
          next:  (data) => {
            this.products = data._embedded.products;
            console.log(data);
          },
          error: (error) => {
            console.error(error) ;
          }
        }
    );
  }

}
