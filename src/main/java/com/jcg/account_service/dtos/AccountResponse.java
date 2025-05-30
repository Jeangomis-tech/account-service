package com.jcg.account_service.dtos;

import com.jcg.account_service.domaines.customer.Customer;

public record AccountResponse(
        Long id,
        Double balance,
        String type,
        String accountNumber,
        Customer customer
) {
}
