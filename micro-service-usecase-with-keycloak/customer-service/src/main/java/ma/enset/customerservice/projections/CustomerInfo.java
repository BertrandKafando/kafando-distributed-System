package ma.enset.customerservice.projections;

import ma.enset.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer", types = Customer.class)
public interface CustomerInfo {
    Long getId();
    String getName();
    String getEmail();
}
