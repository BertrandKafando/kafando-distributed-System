package ma.enset.billingservice.services;

import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.dtos.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceDto);
    InvoiceResponseDTO getInvoiceById(String id);
    InvoiceResponseDTO update(String id, InvoiceRequestDTO invoiceDto);
    boolean delete(String id);
    List<InvoiceResponseDTO> getInvoices();
    List<InvoiceResponseDTO> getInvoicesByCustomerID(String customerID);
}
