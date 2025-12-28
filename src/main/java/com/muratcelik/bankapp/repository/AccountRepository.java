package com.muratcelik.bankapp.repository;


import com.muratcelik.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
