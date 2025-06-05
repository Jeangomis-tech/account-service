package com.jcg.account_service.dtos;


import jakarta.validation.constraints.NotNull;

public record AccountRequest(
        String type,
        Double balance,
        @NotNull(message = "customer id have to be set")Long customerId
        ) {
}
