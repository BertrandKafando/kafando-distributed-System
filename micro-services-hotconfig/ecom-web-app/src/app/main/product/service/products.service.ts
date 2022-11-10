import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product.model";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  endpoint = 'inventory-service/products/';
  constructor(private http: HttpClient) {

  }

  public add(product: Product): Observable<any> {
    const request = this.http.post(environment.url + this.endpoint, product);

    return request;
  }


  public getAll(): Observable<any> {
    const request = this.http.get(environment.url  + this.endpoint + '?projection=fullProduct');
    return request;
  }

}
