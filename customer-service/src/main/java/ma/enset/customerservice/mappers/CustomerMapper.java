package ma.enset.customerservice.mappers;

import ma.enset.customerservice.dtos.CustomerDto;
import ma.enset.customerservice.entities.Customer;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerDto customerDto);
}
