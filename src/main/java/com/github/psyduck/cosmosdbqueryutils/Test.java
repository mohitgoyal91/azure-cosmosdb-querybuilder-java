package com.github.psyduck.cosmosdbqueryutils;

import java.lang.reflect.InvocationTargetException;

public class Test {

    public static void main(String args[]) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        System.out.println("My First Query: " + getSelectQuery());
    }

    private static String getSelectQuery() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return new SelectQuery<>().createQuery();
    }
}
