package com.psyduck.cosmosdbqueryutils;

import com.psyduck.cosmosdbqueryutils.models.Columns;
import com.psyduck.cosmosdbqueryutils.models.Order;
import com.psyduck.cosmosdbqueryutils.restriction.GroupedRestriction;
import com.psyduck.cosmosdbqueryutils.restriction.Restriction;
import com.psyduck.cosmosdbqueryutils.utilities.Constants;
import com.psyduck.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.psyduck.cosmosdbqueryutils.restriction.Restriction.filterRestrictions;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.GENERAL.*;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.Operators.Logical.OR;

public class SelectQuery<T> {

    private boolean isCount;
    private Integer limit;
    private Columns columns = new Columns();
    private List<GroupedRestriction> restrictions = new ArrayList();
    private Order order;
    private StringBuilder queryBuilder = new StringBuilder();

    public SelectQuery(){
    }

    public String createQuery() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        queryBuilder.append(SELECT);
        if(isCount){
            processCount();
        } else {
            processLimit();
            processColumns();
        }
        processFrom();
        processRestrictions();
        processOrder();

        return queryBuilder.toString().trim();
    }

    private void processCount() {
        queryBuilder.append(VALUE_COUNT);
    }

    private void processOrder() {
        Optional.ofNullable(order).ifPresent(order ->
            queryBuilder.append(ORDER_BY)
                    .append(ALIAS)
                    .append(DOT)
                    .append(order.getParameterName())
                    .append(order.getOrder().getName())
        );
    }

    private void processRestrictions() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        filterRestrictions(this.restrictions);
        if(this.restrictions.size() > 0){
            queryBuilder.append(WHERE);
            Restriction.appendGroupedRestrictions(restrictions, queryBuilder);
        }
    }

    private void processFrom() {
        queryBuilder.append(FROM)
                .append(ALIAS);
    }

    private void processLimit() {
        Optional.ofNullable(limit).ifPresent(limit -> {
            queryBuilder.append(TOP).append(limit);
        });
    }

    private void processColumns() {
        if(this.columns.getColumns().size() == 1){
            appendColumn();
        } else {
            appendColumns();
        }
    }

    private void appendColumns() {
        int i;
        for(i=0; i<this.columns.getColumns().size()-1; i++){
            appendColumnToQuery(this.columns.getColumns().get(i), getAlias(i));
            queryBuilder.append(COMMA);
        }
        appendColumnToQuery(this.columns.getColumns().get(i), getAlias(i));
    }

    private void appendColumn() {
        if(this.columns.getColumns().get(0).equalsIgnoreCase(ALL)){
            queryBuilder.append(ALL);
        } else {
            appendColumnToQuery(this.columns.getColumns().get(0), getAlias(0));
        }
    }

    private Optional<String> getAlias(int i) {
        return this.columns.getAlias().size() > i ? Optional.ofNullable(this.columns.getAlias().get(i)) : Optional.empty();
    }

    private void appendColumnToQuery(String parameterName, Optional<String> alias) {
        queryBuilder.append(ALIAS)
                .append(DOT)
                .append(parameterName);
        if(alias.isPresent()){
            queryBuilder.append(AS);
            queryBuilder.append(alias.get());
        }
    }

    public SelectQuery addColumns(Columns columns){
        this.columns = columns;
        return this;
    }

    public SelectQuery limitResults(int limit){
        this.limit = limit;
        return this;
    }

    public SelectQuery addRestrictions(Restriction... restriction){
        GroupedRestriction groupedRestriction = new GroupedRestriction(restriction);

        this.restrictions.add(groupedRestriction);
        return this;
    }

    public SelectQuery orAddRestrictions(Restriction... restrictions){
        if(this.restrictions.size() > 0){
            RestrictionHelper.getLastElementFromList(this.restrictions).setLogicalCombiner(OR);
        }
        this.addRestrictions(restrictions);
        return this;
    }

    public SelectQuery andAddRestrictions(Restriction... restrictions){
        this.addRestrictions(restrictions);
        return this;
    }

    public SelectQuery addOrdering(String parameterName, Constants.Order order) {
       this.order = new Order(parameterName, order);
       return this;
    }

    public SelectQuery count() {
        this.isCount = true;
        return this;
    }
}
