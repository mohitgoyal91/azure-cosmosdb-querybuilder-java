package com.github.mohitgoyal91.cosmosdbqueryutils.models;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.*;

public class Columns {

    private List<String> columns = new ArrayList<>();
    private List<String> alias = new ArrayList<>();

    public Columns(){
        columns.add(Constants.GENERAL.ALL);
    }

    public Columns(String column){
        columns.add(column);
    }

    public Columns(String... requiredColumns){
        columns.addAll(Arrays.asList((String[])requiredColumns));
    }

    public Columns(List<String> columns){
        this.columns = columns;
    }

    public Columns as(String aliass){
        alias.add(aliass);
        return this;
    }

    public Columns as(String... aliass){
        alias.addAll(Arrays.asList((String[])aliass));
        return this;
    }

    public Columns as(List<String> aliass){
        this.alias = aliass;
        return this;
    }

    public List<String> getColumns() {
        return columns;
    }

    public List<String> getAlias() {
        return alias;
    }
}
