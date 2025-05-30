package com.jcg.account_service.services;

import com.jcg.account_service.domaines.Account;
import com.jcg.account_service.dtos.AccountRequest;
import com.jcg.account_service.dtos.AccountResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Long addAccount(AccountRequest dto);
    Long updateAccount(Long id , AccountRequest dto);
    void deleteAccount(Long id);
    Long getAccount(Long id);
    List<AccountResponse> getAllAccount();
}
