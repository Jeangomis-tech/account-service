package com.jcg.account_service.mappers;

import com.jcg.account_service.domaines.Account;
import com.jcg.account_service.domaines.AccountType;
import com.jcg.account_service.dtos.AccountRequest;
import com.jcg.account_service.dtos.AccountResponse;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
  public  AccountResponse toDto(Account account) {
       return new AccountResponse(
               account.getId(),
               account.getBalance(),
               account.getType().name(),
               account.getAccountNumber(),
               account.getCustomer()
       );
    }
   public Account toEntity(AccountRequest dto) {
        return Account.builder()
                .accountNumber(dto.accountNumber())
                .balance(dto.balance())
                .type( AccountType.valueOf(dto.type().toUpperCase()))
                .build();
    }
}
