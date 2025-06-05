package com.jcg.account_service.domaines.customer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
}
