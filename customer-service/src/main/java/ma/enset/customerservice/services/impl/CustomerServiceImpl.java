package ma.enset.customerservice.services.impl;

import lombok.AllArgsConstructor;
import ma.enset.customerservice.dtos.CustomerDto;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.mappers.CustomerMapper;
import ma.enset.customerservice.repositories.CustomerRepository;
import ma.enset.customerservice.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper mapper;

    @Override
    public CustomerDto getCustomerById(String id) {
        Optional<Customer> customer=customerRepository.findById(id);
        if(customer.isPresent()){
            return mapper.customerToCustomerDto(customer.get());
        }
        return null;
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        customerDto.setId(UUID.randomUUID().toString());
       Customer customer= customerRepository.save(mapper.customerDtoToCustomer(customerDto));
        return mapper.customerToCustomerDto(customer);
    }

    @Override
    public CustomerDto update(String id, CustomerDto customerDto) {
        if(customerRepository.findById(id).isPresent()){
            Customer savedCustomer= customerRepository.save(mapper.customerDtoToCustomer(customerDto));
            return mapper.customerToCustomerDto(savedCustomer);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(customerRepository.findById(id).isPresent()){
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        if (customers.size() > 0) {
            return customers
                    .stream()
                    .map(customer -> mapper.customerToCustomerDto(customer))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
