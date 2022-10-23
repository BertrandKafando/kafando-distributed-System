package ma.enset.billingservice.services;

import lombok.RequiredArgsConstructor;
import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.dtos.InvoiceResponseDTO;
import ma.enset.billingservice.entities.Customer;
import ma.enset.billingservice.entities.Invoice;
import ma.enset.billingservice.exceptions.CustomerNotFoundException;
import ma.enset.billingservice.mappers.InvoiceMapper;
import ma.enset.billingservice.openFeign.CustomerRestClient;
import ma.enset.billingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final CustomerRestClient customerService;

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceDto) {
        /*
         * verification de l'integrité refernetielle Invoice /customer
         * */
        Customer customer = null;
        try{
           customer=customerService.getCustomerById(invoiceDto.getCustomerID());
        }catch (Exception e){
            throw  new CustomerNotFoundException("Customer not found");
        }
        Invoice invoice=invoiceMapper.invoiceRequestDtoToInvoice(invoiceDto);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        Invoice savedInvoice=invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDto(savedInvoice);
    }

    @Override
    public InvoiceResponseDTO getInvoiceById(String id) {
        Invoice invoice=invoiceRepository.findById(id).get();
        Customer customer=customerService.getCustomerById(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceResponseDto(invoice);
    }

    @Override
    public InvoiceResponseDTO update(String id, InvoiceRequestDTO invoiceDto) {
        Invoice invoice=invoiceRepository.findById(id).get();
        if(invoice!=null){
            Invoice savedInvoice=invoiceRepository.save(invoiceMapper.invoiceRequestDtoToInvoice(invoiceDto));
            return invoiceMapper.invoiceToInvoiceResponseDto(savedInvoice);
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Invoice invoice=invoiceRepository.findById(id).get();
        if(invoice!=null){
            invoiceRepository.delete(invoice);
            return true;
        }
        return false;
    }

    @Override
    public List<InvoiceResponseDTO> getInvoices() {
        List<Invoice> invoices=invoiceRepository.findAll();

        return invoices.stream()
                .map(invoice -> {
                    Customer customer=customerService.getCustomerById(invoice.getCustomerID());
                    invoice.setCustomer(customer);
                    return invoiceMapper.invoiceToInvoiceResponseDto(invoice);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> getInvoicesByCustomerID(String customerID) {
        List<Invoice> invoices=invoiceRepository.findByCustomerID(customerID);

        return invoices.stream()
                .map(invoice -> {
                    Customer customer=customerService.getCustomerById(invoice.getCustomerID());
                    invoice.setCustomer(customer);
                    return invoiceMapper.invoiceToInvoiceResponseDto(invoice);
                })
                .collect(Collectors.toList());
    }
}
