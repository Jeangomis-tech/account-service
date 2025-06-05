package com.jcg.account_service.domaines.customer;

import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE", url = "${customer.url}")
public interface CustomerClient {

    @GetMapping("/{id}")
    Customer getCustomerById(@Valid @PathVariable Long id);
}
