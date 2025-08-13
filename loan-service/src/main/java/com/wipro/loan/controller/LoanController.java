package com.wipro.loan.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.loan.entity.Loan;
import com.wipro.loan.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/apply")
    public ResponseEntity<Loan> applyLoan(@RequestBody Loan loan) {
        return ResponseEntity.ok(loanService.applyLoan(loan));
    }

    @PostMapping("/{id}/repay")
    public ResponseEntity<Loan> repayLoan(@PathVariable Long id, @RequestBody Double amount) {
        return ResponseEntity.ok(loanService.repayLoan(id, amount));
    }

    @GetMapping("/{id}/interest")
    public ResponseEntity<Double> calculateInterest(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.calculateInterest(id));
    }

    @PostMapping("/{id}/close")
    public ResponseEntity<Loan> closeLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanService.closeLoan(id));
    }
}