import {Product} from "../../product/model/product.model";
import {Order} from "./order.model";

export class ProductItem{
    id?: number;
    quantity?: number;
    price?: number;
    discount ?: number;
    product?: Product;
    order?: Order;
}
