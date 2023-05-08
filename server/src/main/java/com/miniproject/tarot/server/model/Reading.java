package com.miniproject.tarot.server.model;

import java.io.StringReader;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Reading {
    private String readingId;
    private String readingDate;
    private JsonArray cards;

    public String getReadingId() {
        return readingId;
    }
    public void setReadingId(String readingId) {
        this.readingId = readingId;
    }
    public String getReadingDate() {
        return readingDate;
    }
    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
    }
    public JsonArray getCards() {
        return cards;
    }
    public void setCards(JsonArray cards) {
        this.cards = cards;
    }

    public static Reading create(SqlRowSet rs) {
        Reading r = new Reading();
        r.setReadingId(rs.getString("reading_id"));
        r.setReadingDate(rs.getString("reading_date"));
        String json = rs.getString("cards");
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonArray result = reader.readArray();
        r.setCards(result);

        return r;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("readingId", getReadingId())
                .add("cards", getCards())
                .add("readingDate", getReadingDate())
                .build();
    }
    
    
}
