package com.muratcelik.bankapp.service;

import com.muratcelik.bankapp.model.Account;
import com.muratcelik.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransferService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferMoney(Long fromId, Long toId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(() -> new RuntimeException("Gönderen Hesap bulunamadı! Aranan ID: " + fromId));

        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(() -> new RuntimeException("Alıcı Hesap bulunamadı! Aranan ID: " + toId));

        if (fromAccount.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Yetersiz Bakiye!!");
        }
        fromAccount.setBalance(fromAccount.getBalance().subtract(amount)); //parayı çıkar
        toAccount.setBalance(toAccount.getBalance().add(amount));//parayı ekle

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
