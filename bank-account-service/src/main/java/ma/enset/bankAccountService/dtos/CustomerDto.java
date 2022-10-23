package ma.enset.bankAccountService.dtos;

import lombok.Data;
import ma.enset.bankAccountService.dtos.BankAccountDto;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link ma.enset.bankAccountService.entities.Customer} entity
 */
@Data
public class CustomerDto implements Serializable {
    private final Long id;
    private final String name;
    private final String email;
    private final List<BankAccountDto> bankAccounts;
}
