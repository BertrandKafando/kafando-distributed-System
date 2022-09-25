package ma.enset.digitalbankapi.service;

import ma.enset.digitalbankapi.dtos.BankAccountDto;

import java.util.List;

public interface BankAccountService {
    public void deposit(String id, double amount);
    public BankAccountDto save(BankAccountDto bankAccountDto);
    public List<BankAccountDto> getBankAccounts();
    public BankAccountDto getBankAccount(String id);
    public void withdraw(String id, double amount);
    public void transfer(String from, String to, double amount);
    public boolean delete(String id);
}
