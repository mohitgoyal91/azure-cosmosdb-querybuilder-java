package com.github.mohitgoyal91.cosmosdbqueryutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SelectQueryTest {

    @Test
    public void defaultConstructorTest(){
        SelectQuery selectQuery = new SelectQuery();
        assertNotNull(selectQuery);
    }

    @Test
    public void isCountTrueTest(){
        assertTrue(new SelectQuery().count().isCount());
    }

    @Test
    public void isCountFalseTest(){
        assertFalse(new SelectQuery().isCount());
    }
}
