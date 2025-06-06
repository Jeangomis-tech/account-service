package com.jcg.account_service.controllers;

import com.jcg.account_service.domaines.account.Account;
import com.jcg.account_service.dtos.AccountRequest;
import com.jcg.account_service.dtos.AccountResponse;
import com.jcg.account_service.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable Long id) {
        AccountResponse accountResponse = accountService.getAccount(id);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAllAccounts() {
        List<AccountResponse> accounts = accountService.getAllAccount();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAccount(@PathVariable Long id, @Valid @RequestBody AccountRequest dto) {
        Long accountId = accountService.updateAccount(id, dto);

        return new ResponseEntity<>(accountId, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
