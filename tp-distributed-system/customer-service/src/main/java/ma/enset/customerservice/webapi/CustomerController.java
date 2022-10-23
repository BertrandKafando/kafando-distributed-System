package ma.enset.customerservice.webapi;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ma.enset.customerservice.dtos.CustomerDto;
import ma.enset.customerservice.exceptions.NotFoundException;
import ma.enset.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@RequestMapping("/api/customers")
public class CustomerController {
    final private CustomerService customerService;
    @PostMapping
    public CustomerDto save(@RequestBody CustomerDto customerDto){
        return customerService.save(customerDto);
    }
    @GetMapping
    public List<CustomerDto> getCustomers() throws NotFoundException {
        List<CustomerDto>customerDtos=customerService.getCustomers();
        if(customerDtos.isEmpty()) throw new NotFoundException("No customers found");
        return customerService.getCustomers();
    }
    @GetMapping("/{customerId}")
    public CustomerDto getCustomerById(@PathVariable String customerId) throws NotFoundException {
        CustomerDto customerDto=customerService.getCustomerById(customerId);
        if(customerDto==null) throw new NotFoundException("Customer with Id "+ customerId+ " not found");
        return customerDto;
    }
    @PutMapping("/{customerId}")
    public CustomerDto update(@PathVariable String customerId,@RequestBody CustomerDto customerDto) throws NotFoundException {
        CustomerDto customerUpdate=customerService.update(customerId,customerDto);
        if(customerUpdate==null) throw new NotFoundException("Customer with Id "+ customerId+ " not found");
        return customerUpdate;
    }
    @DeleteMapping("/{customerId}")
    public boolean delete(@PathVariable String customerId) throws NotFoundException {
        boolean deleted=customerService.delete(customerId);
        if(!deleted) throw new NotFoundException("Customer with Id "+ customerId+ " not found");
        return deleted;
    }

}
