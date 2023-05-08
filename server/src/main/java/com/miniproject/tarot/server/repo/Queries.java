package com.miniproject.tarot.server.repo;

public class Queries {
    
    public static final String SQL_GET_SINGLE_CARD = "select * from mytable where id = ?";

    public static final String SQL_GET_THREE_CARDS = "select * from mytable where id in (?, ?, ?)";

    public static final String SQL_SAVE_READING = "insert into mysaved(reading_id, cards, reading_date) values(?, ?, ?) ";

    public static final String SQL_DELETE_READING = "delete from mysaved where reading_id = ?";

    public static final String SQL_GET_SAVED = "select * from mysaved";

    public static final String SQL_SEARCH_CARD_BY_NAME_SUIT = "select * from mytable where name like CONCAT( '%',?,'%') and suit like CONCAT( '%',?,'%')";

    public static final String SQL_SEARCH_CARD_BY_NAME = "select * from mytable where name like CONCAT( '%',?,'%')";

    public static final String SQL_SEARCH_CARD_BY_SUIT = "select * from mytable where suit like CONCAT( '%',?,'%')";
}
