package com.wipro.card.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.card.entity.Card;
import com.wipro.card.service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/issue")
    public ResponseEntity<Card> issueCard(@RequestBody Card card) {
        return ResponseEntity.ok(cardService.issueCard(card));
    }

    @PostMapping("/{id}/block")
    public ResponseEntity<Card> blockCard(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.blockCard(id));
    }

    @PostMapping("/{id}/close")
    public ResponseEntity<Card> closeCard(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.closeCard(id));
    }
}
