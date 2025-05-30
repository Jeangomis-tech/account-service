package com.jcg.account_service.dtos;

import jakarta.validation.constraints.NotBlank;

public record AccountRequest(
        String accountNumber,
        String type,
        Double balance,
        @NotBlank(message = "customer id can not be blank")Long customerId
        ) {
}
