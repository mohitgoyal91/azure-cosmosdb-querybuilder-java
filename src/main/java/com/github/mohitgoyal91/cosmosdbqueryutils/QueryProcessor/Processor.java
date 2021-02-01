package com.github.mohitgoyal91.cosmosdbqueryutils.QueryProcessor;

import com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate.Aggregate;
import com.github.mohitgoyal91.cosmosdbqueryutils.SelectQuery;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.Restriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.Optional;

import static com.github.mohitgoyal91.cosmosdbqueryutils.restriction.Restriction.filterRestrictions;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.GENERAL.ALL;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.GENERAL.COMMA;

/**
 * The type Processor.
 */
public class Processor {

    private StringBuilder queryBuilder = new StringBuilder();
    private SelectQuery selectQuery;

    /**
     * Instantiates a new Processor.
     *
     * @param selectQuery the select query
     */
    public Processor(SelectQuery selectQuery) {
        this.selectQuery = selectQuery;
    }

    /**
     * Process query string.
     *
     * @return the string
     */
    public String processQuery() {
        queryBuilder.append(Constants.GENERAL.SELECT);
        if(selectQuery.isCount()){
            processCount();
        } else {
            processLimit();
            processColumns();
        }
        processFrom();
        processRestrictions();
        processOrder();
        processOffsetLimit();

        return queryBuilder.toString().trim().replaceAll("( )+", " ");
    }

    private void processCount() {
        queryBuilder.append(Constants.GENERAL.VALUE_COUNT);
    }

    private void processOrder() {
        Optional.ofNullable(selectQuery.getOrder()).ifPresent(order ->
                queryBuilder.append(Constants.GENERAL.ORDER_BY)
                        .append(Constants.GENERAL.ALIAS)
                        .append(Constants.GENERAL.DOT)
                        .append(order.getParameterName())
                        .append(order.getOrder().getName())
        );
    }

    private void processOffsetLimit() {
        Optional.ofNullable(selectQuery.getOffsetLimit()).ifPresent(offsetLimit -> 
            queryBuilder.append(Constants.GENERAL.OFFSET)
                .append(offsetLimit.getOffset())
                .append(Constants.GENERAL.LIMIT)
                .append(offsetLimit.getLimit())
        );
    }

    private void processRestrictions(){
        try{
            filterRestrictions(selectQuery.getRestrictions());
            if(selectQuery.getRestrictions().size() > 0){
                queryBuilder.append(Constants.GENERAL.WHERE);
                Restriction.appendGroupedRestrictions(selectQuery.getRestrictions(), queryBuilder);
            }
        } catch (Exception e){

        }
    }

    private void processFrom() {
        queryBuilder.append(Constants.GENERAL.FROM)
                .append(Constants.GENERAL.ALIAS);
    }

    private void processLimit() {
        Optional.ofNullable(selectQuery.getLimit()).ifPresent(limit -> {
            queryBuilder.append(Constants.GENERAL.TOP).append(limit);
        });
    }

    private void processColumns() {
        if(!selectQuery.getAggregateFunctions().isEmpty()){
            processAggregateColumns();
        }else{
            processSimpleColumns();
        }
    }

    private void processAggregateColumns() {
        int i;
        for(i=0; i<selectQuery.getAggregateFunctions().size()-1; i++){
            Aggregate.appendAggregateExpression(selectQuery.getAggregateFunctions().get(i), queryBuilder);
            queryBuilder.append(COMMA);
        }
        Aggregate.appendAggregateExpression(selectQuery.getAggregateFunctions().get(i), queryBuilder);
    }

    private void processSimpleColumns() {
        if(selectQuery.getColumns().getColumns().size() == 1){
            appendColumn();
        } else {
            appendColumns();
        }
    }

    private void appendColumns() {
        int i;
        for(i=0; i<selectQuery.getColumns().getColumns().size()-1; i++){
            appendColumnToQuery(selectQuery.getColumns().getColumns().get(i), getAlias(i));
            queryBuilder.append(COMMA);
        }
        appendColumnToQuery(selectQuery.getColumns().getColumns().get(i), getAlias(i));
    }

    private void appendColumn() {
        if(selectQuery.getColumns().getColumns().get(0).equalsIgnoreCase(Constants.GENERAL.ALL)){
            queryBuilder.append(Constants.GENERAL.ALL);
        } else {
            appendColumnToQuery(selectQuery.getColumns().getColumns().get(0), getAlias(0));
        }
    }

    private Optional<String> getAlias(int i) {
        return selectQuery.getColumns().getAlias().size() > i ? Optional.ofNullable(selectQuery.getColumns().getAlias().get(i)) : Optional.empty();
    }

    private void appendColumnToQuery(String parameterName, Optional<String> alias) {
        queryBuilder.append(Constants.GENERAL.ALIAS)
                .append(Constants.GENERAL.DOT)
                .append(parameterName);
        if(alias.isPresent()){
            queryBuilder.append(Constants.GENERAL.AS);
            queryBuilder.append(alias.get());
        }
    }
}
