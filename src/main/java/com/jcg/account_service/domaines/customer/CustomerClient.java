package com.jcg.account_service.domaines.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER_SERVICE", url = "${customer.url}")
public interface CustomerClient {

    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
}
