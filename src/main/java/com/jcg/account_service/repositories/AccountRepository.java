package com.jcg.account_service.repositories;

import com.jcg.account_service.domaines.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
