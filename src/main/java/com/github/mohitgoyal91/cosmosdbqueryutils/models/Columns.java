package com.github.mohitgoyal91.cosmosdbqueryutils.models;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.*;

/**
 * The type Columns.
 */
public class Columns {

    private List<String> columns = new ArrayList<>();
    private List<String> alias = new ArrayList<>();

    /**
     * Instantiates a new Columns.
     */
    public Columns(){
        columns.add(Constants.GENERAL.ALL);
    }

    /**
     * Instantiates a new Columns.
     *
     * @param column the column
     */
    public Columns(String column){
        columns.add(column);
    }

    /**
     * Instantiates a new Columns.
     *
     * @param requiredColumns the required columns
     */
    public Columns(String... requiredColumns){
        columns.addAll(Arrays.asList((String[])requiredColumns));
    }

    /**
     * Instantiates a new Columns.
     *
     * @param columns the columns
     */
    public Columns(List<String> columns){
        this.columns = columns;
    }

    /**
     * As columns.
     *
     * @param aliass the aliass
     * @return the columns
     */
    public Columns as(String aliass){
        alias.add(aliass);
        return this;
    }

    /**
     * As columns.
     *
     * @param aliass the aliass
     * @return the columns
     */
    public Columns as(String... aliass){
        alias.addAll(Arrays.asList((String[])aliass));
        return this;
    }

    /**
     * As columns.
     *
     * @param aliass the aliass
     * @return the columns
     */
    public Columns as(List<String> aliass){
        this.alias = aliass;
        return this;
    }

    /**
     * Gets columns.
     *
     * @return the columns
     */
    public List<String> getColumns() {
        return columns;
    }

    /**
     * Gets alias.
     *
     * @return the alias
     */
    public List<String> getAlias() {
        return alias;
    }
}
