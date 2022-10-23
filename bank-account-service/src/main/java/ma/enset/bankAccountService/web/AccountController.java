package ma.enset.bankAccountService.web;

import lombok.AllArgsConstructor;
import ma.enset.bankAccountService.dtos.BankAccountDto;
import ma.enset.bankAccountService.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {

    BankAccountService bankAccountService;

    @GetMapping()
    public List<BankAccountDto> getAccounts(){
        return bankAccountService.getBankAccounts();
    }

    @PostMapping()
    public BankAccountDto saveAccount(BankAccountDto bankAccountDto){
        bankAccountDto.setId(UUID.randomUUID().toString());
        bankAccountDto.setCreatedAt(new Date());
        return bankAccountService.save(bankAccountDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAccount(@PathVariable(name = "id") String id){
        return bankAccountService.delete(id);
    }

    @GetMapping("/{id}")
    public BankAccountDto getAccount(@PathVariable(name = "id") String id){
        return bankAccountService.getBankAccount(id);
    }


}
