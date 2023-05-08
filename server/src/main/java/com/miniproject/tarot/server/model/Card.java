package com.miniproject.tarot.server.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Card {
    public int id;
    public String name;
    public int number;
    public String suit;
    public String img;
    public String fortune_telling0;
    public String fortune_telling1;
    public String fortune_telling2;
    public String fortune_telling3;
    public String keywords0;
    public String keywords1;
    public String keywords2;
    public String keywords3;
    public String keywords4;
    public String keywords5;
    public String keywords6;
    public String Questions_to_Ask0;
    public String Questions_to_Ask1;
    public String Questions_to_Ask2;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getFortune_telling0() {
        return fortune_telling0;
    }
    public void setFortune_telling0(String fortune_telling0) {
        this.fortune_telling0 = fortune_telling0;
    }
    public String getFortune_telling1() {
        return fortune_telling1;
    }
    public void setFortune_telling1(String fortune_telling1) {
        this.fortune_telling1 = fortune_telling1;
    }
    public String getFortune_telling2() {
        return fortune_telling2;
    }
    public void setFortune_telling2(String fortune_telling2) {
        this.fortune_telling2 = fortune_telling2;
    }
    public String getFortune_telling3() {
        return fortune_telling3;
    }
    public void setFortune_telling3(String fortune_telling3) {
        this.fortune_telling3 = fortune_telling3;
    }
    public String getKeywords0() {
        return keywords0;
    }
    public void setKeywords0(String keywords0) {
        this.keywords0 = keywords0;
    }
    public String getKeywords1() {
        return keywords1;
    }
    public void setKeywords1(String keywords1) {
        this.keywords1 = keywords1;
    }
    public String getKeywords2() {
        return keywords2;
    }
    public void setKeywords2(String keywords2) {
        this.keywords2 = keywords2;
    }
    public String getKeywords3() {
        return keywords3;
    }
    public void setKeywords3(String keywords3) {
        this.keywords3 = keywords3;
    }
    public String getKeywords4() {
        return keywords4;
    }
    public void setKeywords4(String keywords4) {
        this.keywords4 = keywords4;
    }
    public String getKeywords5() {
        return keywords5;
    }
    public void setKeywords5(String keywords5) {
        this.keywords5 = keywords5;
    }
    public String getKeywords6() {
        return keywords6;
    }
    public void setKeywords6(String keywords6) {
        this.keywords6 = keywords6;
    }
    public String getQuestions_to_Ask0() {
        return Questions_to_Ask0;
    }
    public void setQuestions_to_Ask0(String questions_to_Ask0) {
        Questions_to_Ask0 = questions_to_Ask0;
    }
    public String getQuestions_to_Ask1() {
        return Questions_to_Ask1;
    }
    public void setQuestions_to_Ask1(String questions_to_Ask1) {
        Questions_to_Ask1 = questions_to_Ask1;
    }
    public String getQuestions_to_Ask2() {
        return Questions_to_Ask2;
    }
    public void setQuestions_to_Ask2(String questions_to_Ask2) {
        Questions_to_Ask2 = questions_to_Ask2;
    }

    public static Card create(SqlRowSet rs) {
        Card c = new Card();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));
        c.setNumber(rs.getInt("number"));
        c.setSuit(rs.getString("suit"));
        c.setImg(rs.getString("img"));
        c.setFortune_telling0(rs.getString("fortune_telling0"));
        c.setFortune_telling1(rs.getString("fortune_telling1"));
        c.setFortune_telling2(rs.getString("fortune_telling2"));
        c.setFortune_telling3(rs.getString("fortune_telling3"));
        c.setKeywords0(rs.getString("keywords0"));
        c.setKeywords1(rs.getString("keywords1"));
        c.setKeywords2(rs.getString("keywords2"));
        c.setKeywords3(rs.getString("keywords3"));
        c.setKeywords4(rs.getString("keywords4"));
        c.setKeywords5(rs.getString("keywords5"));
        c.setKeywords6(rs.getString("keywords6"));
        c.setQuestions_to_Ask0(rs.getString("Questions_to_Ask0"));
        c.setQuestions_to_Ask1(rs.getString("Questions_to_Ask1"));
        c.setQuestions_to_Ask2(rs.getString("Questions_to_Ask2"));

        return c;
    }

    public static Card create(JsonObject json) {
        Card c = new Card();
        c.setId(json.getInt("id"));
        c.setName(json.getString("name"));
        c.setNumber(json.getInt("number"));
        c.setSuit(json.getString("suit"));
        c.setImg(json.getString("img"));
        c.setFortune_telling0(json.getString("fortune_telling0") == null ? "" : json.getString("fortune_telling0"));
        c.setFortune_telling1(json.getString("fortune_telling1") == null ? "" : json.getString("fortune_telling1"));
        c.setFortune_telling2(json.getString("fortune_telling2") == null ? "" : json.getString("fortune_telling2"));
        c.setFortune_telling3(json.getString("fortune_telling3") == null ? "" : json.getString("fortune_telling3"));
        c.setKeywords0(json.getString("keywords0") == null ? "" : json.getString("keywords0"));
        c.setKeywords1(json.getString("keywords1") == null ? "" : json.getString("keywords1"));
        c.setKeywords2(json.getString("keywords2") == null ? "" : json.getString("keywords2"));
        c.setKeywords3(json.getString("keywords3") == null ? "" : json.getString("keywords3"));
        c.setKeywords4(json.getString("keywords4") == null ? "" : json.getString("keywords4"));
        c.setKeywords5(json.getString("keywords5") == null ? "" : json.getString("keywords5"));
        c.setKeywords6(json.getString("keywords6") == null ? "" : json.getString("keywords6"));
        c.setQuestions_to_Ask0(json.getString("Questions_to_Ask0") == null ? "" : json.getString("Questions_to_Ask0"));
        c.setQuestions_to_Ask0(json.getString("Questions_to_Ask1") == null ? "" : json.getString("Questions_to_Ask1"));
        c.setQuestions_to_Ask0(json.getString("Questions_to_Ask2") == null ? "" : json.getString("Questions_to_Ask2"));

        return c;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("id", getId())
                .add("name", getName())
                .add("number", getNumber())
                .add("suit", getSuit())
                .add("img", getImg())
                .add("fortune_telling0", getFortune_telling0() == null ? "" : getFortune_telling0())
                .add("fortune_telling1", getFortune_telling1() == null ? "" : getFortune_telling1())
                .add("fortune_telling2", getFortune_telling2() == null ? "" : getFortune_telling2())
                .add("fortune_telling3", getFortune_telling3() == null ? "" : getFortune_telling3())
                .add("keywords0", getKeywords0() == null ? "" : getKeywords0())
                .add("keywords1", getKeywords1() == null ? "" : getKeywords1())
                .add("keywords2", getKeywords2() == null ? "" : getKeywords2())
                .add("keywords3", getKeywords3() == null ? "" : getKeywords3())
                .add("keywords4", getKeywords4() == null ? "" : getKeywords4())
                .add("keywords5",getKeywords5() == null ? "" : getKeywords5())
                .add("keywords6", getKeywords6() == null ? "" : getKeywords6())
                .add("Questions_to_Ask0", getQuestions_to_Ask0() == null ? "" : getQuestions_to_Ask0())
                .add("Questions_to_Ask1", getQuestions_to_Ask1() == null ? "" : getQuestions_to_Ask1())
                .add("Questions_to_Ask2", getQuestions_to_Ask2() == null ? "" : getQuestions_to_Ask2())
                .build();
    }



    
}
