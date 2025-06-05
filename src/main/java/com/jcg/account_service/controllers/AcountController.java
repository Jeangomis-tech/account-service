package com.jcg.account_service.controllers;

import com.jcg.account_service.domaines.account.Account;
import com.jcg.account_service.dtos.AccountRequest;
import com.jcg.account_service.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("acounts")
public class AcountController {

    private final AccountService accountService;

    public AcountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<Long> createAccount( @Valid @RequestBody AccountRequest dto) {
      Long accountId = accountService.addAccount(dto);
      return new ResponseEntity<>(accountId, HttpStatus.CREATED);
//      return ResponseEntity.ok(accountId);
    }
}
