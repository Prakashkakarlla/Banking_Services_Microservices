package com.wipro.transaction.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.transaction.entity.Transaction;
import com.wipro.transaction.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> deposit(@RequestParam String accountId, @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.deposit(accountId, amount));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestParam String accountId, @RequestParam Double amount) {
        return ResponseEntity.ok(transactionService.withdraw(accountId, amount));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String accountId) {
        return ResponseEntity.ok(transactionService.getTransactions(accountId));
    }
}

