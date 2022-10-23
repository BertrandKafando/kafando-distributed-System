package ma.enset.bankAccountService.web;

import lombok.AllArgsConstructor;
import ma.enset.bankAccountService.dtos.BankAccountDto;
import ma.enset.bankAccountService.service.BankAccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class BankAccounGrapqlController {
    private BankAccountService bankAccountService;
    @QueryMapping
    public List<BankAccountDto>getaccoutns(){
        return bankAccountService.getBankAccounts();
    }

    @QueryMapping
    public BankAccountDto getAccountById(@Argument String id){
        return bankAccountService.getBankAccount(id);
    }
    @MutationMapping
    public BankAccountDto  createAccount(@Argument BankAccountDto account){
        account.setId(UUID.randomUUID().toString());
        account.setCreatedAt(new Date());
        return bankAccountService.save(account);
    }

}
