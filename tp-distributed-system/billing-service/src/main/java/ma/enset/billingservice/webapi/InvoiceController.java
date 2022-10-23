package ma.enset.billingservice.webapi;

import lombok.RequiredArgsConstructor;
import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.dtos.InvoiceResponseDTO;
import ma.enset.billingservice.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class InvoiceController {
    final  private InvoiceService invoiceService;
    @GetMapping("/invoices/{id}")
    public InvoiceResponseDTO getInvoiceById(@PathVariable String id){
        return invoiceService.getInvoiceById(id);
    }

    @GetMapping("/invoices/{customerID}")
    public List<InvoiceResponseDTO>getInvoicesByCustomerID(@PathVariable String customerID){
        return invoiceService.getInvoicesByCustomerID(customerID);
    }

    @GetMapping("/invoices")
    public List<InvoiceResponseDTO> getInvoices(){
        return invoiceService.getInvoices();
    }

    @PostMapping("/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceDto){
        return invoiceService.save(invoiceDto);
    }

    @DeleteMapping("/invoices/{id}")
    public boolean delete(@PathVariable String id){
        return invoiceService.delete(id);
    }

    @PutMapping("/invoices/{id}")
    public InvoiceResponseDTO update(@PathVariable String id,@RequestBody InvoiceRequestDTO invoiceDto){
        return invoiceService.update(id,invoiceDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
