package com.miniproject.tarot.server.controller;

import java.io.StringReader;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.Response;
import com.miniproject.tarot.server.model.Card;
import com.miniproject.tarot.server.model.Reading;
import com.miniproject.tarot.server.repo.CardRepo;
import com.miniproject.tarot.server.service.S3Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class CardController {

    @Autowired
    private S3Service s3Svc;

    @Autowired
    private CardRepo cardRepo;
    
    @GetMapping("/get-1")
    @ResponseBody
    public ResponseEntity<String> getOneCard() {
        int randomNo = new Random().nextInt(78 + 1);
        
        // get one card from repo
        Optional<Card> cOpt = cardRepo.getSingleCard(randomNo);

        if (cOpt.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        JsonObject response = cOpt.get().toJSON();
        
        return ResponseEntity.ok(response.toString());

    }

    @GetMapping("/get-3")
    @ResponseBody
    public ResponseEntity<String> getThreeCards() {
        Set<Integer> randomNos = new HashSet<>();
        while (randomNos.size() < 3) {
            int randomNo = new Random().nextInt(78 + 1);
            randomNos.add(randomNo);
        }

        // get 3 cards from repo
        Optional<List<Card>> cardList = cardRepo.getThreeCards(randomNos);

        if (cardList.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Card c : cardList.get()) {
            jab.add(c.toJSON());
        }
        JsonArray response = jab.build();

        return ResponseEntity.ok(response.toString());
    }

    @GetMapping(path="/saved")
    @ResponseBody
    public ResponseEntity<String> getSavedReadings() {
        Optional<List<Reading>> readingsOpt = cardRepo.getSavedReadings();

        if (readingsOpt.isEmpty()) return ResponseEntity.badRequest().build();

        List<Reading> readings = readingsOpt.get();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Reading r : readings) {
            jab.add(r.toJSON());
        }

        return ResponseEntity.ok(jab.build().toString());
    }

    @PostMapping(path="/save-reading", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> saveReading(@RequestBody String payload) {
        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject result = reader.readObject();
        JsonArray ja = Json.createArrayBuilder().add(result).build();
        String readingId = UUID.randomUUID().toString().substring(0, 4);

        boolean saved = cardRepo.saveReadingById(readingId, ja.toString(), new Date().toString());

        return ResponseEntity.ok(Json.createObjectBuilder().add("saved", saved).toString());
    }

    @PostMapping(path="/save-readings", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> saveReadings(@RequestBody String payload) {
        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray result = reader.readArray();
        System.out.println(result);
        String readingId = UUID.randomUUID().toString().substring(0, 4);

        boolean saved = cardRepo.saveReadingById(readingId, result.toString(), new Date().toString());

        return ResponseEntity.ok(Json.createObjectBuilder().add("saved", saved).toString());
    }

    @DeleteMapping("/delete-reading/{readingId}")
    @ResponseBody
    public ResponseEntity<String> deleteReading(@PathVariable int readingId) {
        boolean deleted = cardRepo.deleteReadingById(readingId);

        if (!deleted) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(Json.createObjectBuilder().add("deleted", "true").toString());
    }

}
