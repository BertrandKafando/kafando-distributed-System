package ma.enset.customerservice.services;

import ma.enset.customerservice.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto getCustomerById(String id);
    CustomerDto save(CustomerDto customerDto);
    CustomerDto update(String id, CustomerDto customerDto);
    boolean delete(String id);
    List<CustomerDto> getCustomers();

}
