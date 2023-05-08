package com.miniproject.tarot.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.tarot.server.model.Card;
import com.miniproject.tarot.server.repo.CardRepo;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class SearchController {

    @Autowired
    private CardRepo cardRepo;
    
    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<String> searchCardsByName(@RequestParam(value="name", required=false) String name, 
                                            @RequestParam(value="suit", required=false) String suit) {
        Optional<List<Card>> cardList;
        if (name != null & suit != null) {
            cardList = cardRepo.searchCardsByNameSuit(name, suit);
        } else if (name != null & suit == null) {
            cardList = cardRepo.searchCardsByName(name);
        } else {
            cardList = cardRepo.searchCardsBySuit(suit);
        }

        if (cardList.isEmpty()) return ResponseEntity.badRequest().build();

        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Card c : cardList.get()) {
            jab.add(c.toJSON());
        }
        JsonArray response = jab.build();

        // save to redis

        return ResponseEntity.ok(response.toString());
    }
}
