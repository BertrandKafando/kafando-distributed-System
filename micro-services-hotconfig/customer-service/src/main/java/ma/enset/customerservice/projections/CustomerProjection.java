package ma.enset.customerservice.projections;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer",types = ma.enset.customerservice.entities.Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getName();
    public String getEmail();
}
