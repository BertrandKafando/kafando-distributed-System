import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../../environments/environment";
import {Customer} from "../model/customer.model";

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  endpoint = 'customer-service/customers';
  constructor(private http: HttpClient) {

  }

  public add(customer: Customer): Observable<any> {
    const request = this.http.post(environment.url + this.endpoint, customer);

    return request;
  }

  public getAll(): Observable<any> {
    const request = this.http.get(environment.url  + this.endpoint+ '?projection=fullCustomer');
    return request;
  }

}
