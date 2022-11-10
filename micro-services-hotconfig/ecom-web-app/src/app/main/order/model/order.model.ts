
import {OrderStatus} from "../../../utils/OrderStatus";

export  class Order{
    id ?: number;
    createdAt ?: Date;
    status ?: OrderStatus;
    customerId ?: string;
}
