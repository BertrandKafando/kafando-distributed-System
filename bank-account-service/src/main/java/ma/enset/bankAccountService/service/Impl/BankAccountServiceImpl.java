package ma.enset.bankAccountService.service.Impl;

import lombok.AllArgsConstructor;
import ma.enset.bankAccountService.dtos.BankAccountDto;
import ma.enset.bankAccountService.entities.BankAccount;
import ma.enset.bankAccountService.mappers.ObjectMapperUtils;
import ma.enset.bankAccountService.repositories.BankAccountRepository;
import ma.enset.bankAccountService.service.BankAccountService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    BankAccountRepository bankAccountRepository;
    @Override
    public void deposit(String id, double amount) {

    }

    @Override
    public BankAccountDto save(BankAccountDto bankAccountDto) {
      BankAccount bankAccount=   bankAccountRepository.save(ObjectMapperUtils.map(bankAccountDto,ma.enset.bankAccountService.entities.BankAccount.class));
       if (bankAccount!=null){
           return ObjectMapperUtils.map(bankAccount,BankAccountDto.class);
         }
        return null;
    }

    @Override
    public List<BankAccountDto> getBankAccounts() {
        List<BankAccountDto> bankAccountDtos = ObjectMapperUtils.mapAll(bankAccountRepository.findAll(), BankAccountDto.class);
        if(bankAccountDtos.size()>0){
            return bankAccountDtos;
        }
        return null;
    }

    @Override
    public BankAccountDto getBankAccount(String id) {
     bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account with id %s not found",id)));
            return ObjectMapperUtils.map(bankAccountRepository.findById(id).get(),BankAccountDto.class);

    }

    @Override
    public void withdraw(String id, double amount) {

    }

    @Override
    public void transfer(String from, String to, double amount) {

    }

    @Override
    public boolean delete(String id) {
        if (bankAccountRepository.existsById(id)) {
            bankAccountRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
