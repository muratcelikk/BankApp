package com.muratcelik.bankapp.controller;

import com.muratcelik.bankapp.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private TransferService transferService;

    @PostMapping("/transfer")
    public String transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam BigDecimal amount) {
        try {
            transferService.transferMoney(from, to, amount);
            return "Transfer Success";
        } catch (Exception e) {
            return "Hata: " + e.getMessage();
        }
    }
}
