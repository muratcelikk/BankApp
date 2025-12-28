package com.muratcelik.bankapp.controller;

import com.muratcelik.bankapp.model.Account;
import com.muratcelik.bankapp.repository.AccountRepository;
import com.muratcelik.bankapp.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam BigDecimal amount) {
        try {
            transferService.transferMoney(from, to, amount);
            return "Transfer Success";
        } catch (Exception e) {
            return "Hata: " + e.getMessage();
        }
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
