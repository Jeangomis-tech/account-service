package com.jcg.account_service.mappers;

import com.jcg.account_service.domaines.account.Account;
import com.jcg.account_service.domaines.account.AccountType;
import com.jcg.account_service.dtos.AccountRequest;
import com.jcg.account_service.dtos.AccountResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
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
       Account account = new Account();
       account.setBalance(dto.balance());
       account.setType(AccountType.valueOf(dto.type().toUpperCase()));
       return account;
    }
}
