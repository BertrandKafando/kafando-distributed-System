package ma.enset.digitalbankapi.dtos;

import lombok.Data;
import ma.enset.digitalbankapi.enums.AccountType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link ma.enset.digitalbankapi.entities.BankAccount} entity
 */
@Data
public class BankAccountDto implements Serializable {
    private  String id;
    private  Date createdAt;
    private  Double balance;
    private  String currency;
    @Enumerated(EnumType.STRING)
    private  AccountType accountType;
}
