package com.jcg.account_service.domaines;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double balance = 0.0;
    private Long customerId;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    @Column(unique=true, nullable=false)
    private String accountNumber;
    private Long custmerId;

}
