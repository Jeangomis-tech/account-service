package com.jcg.account_service.services.impl;

import com.jcg.account_service.domaines.Account;
import com.jcg.account_service.dtos.AccountRequest;
import com.jcg.account_service.dtos.AccountResponse;
import com.jcg.account_service.mappers.AccountMapper;
import com.jcg.account_service.repositories.AccountRepository;
import com.jcg.account_service.services.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public Long addAccount(AccountRequest dto) {
        Account account = accountMapper.toEntity(dto);
        Account savedAccount = accountRepository.save(account);
        return savedAccount.getId();

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
    public Long getAccount(Long id) {
        return null;
    }

    @Override
    public List<AccountResponse> getAllAccount() {
        return List.of();
    }
}
