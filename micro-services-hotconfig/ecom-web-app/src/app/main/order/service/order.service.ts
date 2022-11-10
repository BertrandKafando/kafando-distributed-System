import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../../environments/environment";
import {Order} from "../model/order.model";

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  endpoint = 'order-service/orders';
  constructor(private http: HttpClient) {

  }

  public add(order: Order): Observable<any> {
    const request = this.http.post(environment.url + this.endpoint, order);

    return request;
  }

  public getAll(): Observable<any> {
    const request = this.http.get(environment.url  + this.endpoint+ '?projection=fullOrder');
    return request;
  }

  public getbyCustomer(id: number): Observable<any> {
    const request = this.http.get(environment.url + this.endpoint+ '/search/byCustomerId?projection=fullOrder&customerId=' +id );
    return request;
  }

  public getOrder(id: number): Observable<any> {
    const request = this.http.get(environment.url+ 'order-service/fullOrder/' +id );
    return request;
  }

}
