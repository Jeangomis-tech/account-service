package com.jcg.account_service.services.impl;

import com.jcg.account_service.domaines.account.Account;
import com.jcg.account_service.domaines.customer.Customer;
import com.jcg.account_service.domaines.customer.CustomerClient;
import com.jcg.account_service.dtos.AccountRequest;
import com.jcg.account_service.dtos.AccountResponse;
import com.jcg.account_service.mappers.AccountMapper;
import com.jcg.account_service.repositories.AccountRepository;
import com.jcg.account_service.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final CustomerClient client;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper, CustomerClient client) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.client = client;
    }

    @Override
    public Long addAccount(AccountRequest dto) {
        Customer customer = client.getCustomerById(dto.customerId());
        if(customer == null) {
            throw new IllegalArgumentException("Customer not found");
        }
        System.out.println(customer.getEmail() + " " + customer.getFirstName() + " " + customer.getLastName());
        Account account = accountMapper.toEntity(dto);
        account.setAccountNumber(generateAccountNumber());
//        Account savedAccount = accountRepository.save(account);
//        return savedAccount.getId();
        return 1L;

    }

    @Override
    public Long updateAccount(Long id, AccountRequest dto) {
        Account account = accountMapper.toEntity(dto);
        account.setId(id);
        Account updatedAccount = accountRepository.save(account);
        return  updatedAccount.getId();
    }

    @Override
    public void deleteAccount(Long id) {

    }

    @Override
    public AccountResponse getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account with id" + id +" not found"));
        return accountMapper.toDto(account);
    }

    @Override
    public List<AccountResponse> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(accountMapper::toDto).toList();
    }
    private String generateAccountNumber() {
        return "ACC" +  String.valueOf( System.currentTimeMillis()) +  UUID.randomUUID().toString().substring(0, 8);
    }
}
