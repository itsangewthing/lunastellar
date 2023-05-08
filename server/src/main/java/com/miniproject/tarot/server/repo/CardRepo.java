package com.miniproject.tarot.server.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.miniproject.tarot.server.model.Card;
import com.miniproject.tarot.server.model.Reading;

import static com.miniproject.tarot.server.repo.Queries.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class CardRepo {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    public Optional<Card> getSingleCard(int id) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_SINGLE_CARD, id);

        Card c = new Card();
        while (rs.next()) {
            c = Card.create(rs);
        }

        return Optional.of(c);
    }

    public Optional<List<Card>> getThreeCards(Set<Integer> ids) {
        List<Integer> idsList = ids.stream().toList();
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_THREE_CARDS, idsList.get(0), idsList.get(1), idsList.get(2));

        List<Card> cardsList = new LinkedList<>();
        while (rs.next()) {
            cardsList.add(Card.create(rs));
        }

        if (cardsList.size() != 3) return Optional.empty();

        return Optional.of(cardsList);
    }
    
    public Optional<List<Card>> searchCardsByNameSuit(String name, String suit) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SEARCH_CARD_BY_NAME_SUIT, name, suit);

        List<Card> cardsList = new LinkedList<>();
        while (rs.next()) {
            cardsList.add(Card.create(rs));
        }

        if (cardsList.size() == 0) return Optional.empty();

        return Optional.of(cardsList);
    }

    public Optional<List<Card>> searchCardsByName(String name) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SEARCH_CARD_BY_NAME, name);

        List<Card> cardsList = new LinkedList<>();
        while (rs.next()) {
            cardsList.add(Card.create(rs));
        }

        if (cardsList.size() == 0) return Optional.empty();

        return Optional.of(cardsList);
    }

    public Optional<List<Card>> searchCardsBySuit(String suit) {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SEARCH_CARD_BY_SUIT, suit);

        List<Card> cardsList = new LinkedList<>();
        while (rs.next()) {
            cardsList.add(Card.create(rs));
        }

        if (cardsList.size() == 0) return Optional.empty();

        return Optional.of(cardsList);
    }

    public boolean saveReadingById(String readingId, String cards, String savedDate) {
        int saved = jdbcTemplate.update(SQL_SAVE_READING, readingId, cards, savedDate);

        return saved > 0;
    }

    public boolean deleteReadingById(int readingId) {
        int deleted = jdbcTemplate.update(SQL_DELETE_READING, readingId);

        return deleted > 0;
    }

    public Optional<List<Reading>> getSavedReadings() {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_SAVED);

        List<Reading> readings = new LinkedList<>();
        while (rs.next()) {
            readings.add(Reading.create(rs));
        }

        return Optional.of(readings);
    }
}
