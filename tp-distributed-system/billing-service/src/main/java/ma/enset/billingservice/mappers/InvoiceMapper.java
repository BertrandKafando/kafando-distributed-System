package ma.enset.billingservice.mappers;

import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.dtos.InvoiceResponseDTO;
import ma.enset.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice invoiceRequestDtoToInvoice(InvoiceRequestDTO invoiceDto);
    InvoiceResponseDTO invoiceToInvoiceResponseDto(Invoice invoice);
}
