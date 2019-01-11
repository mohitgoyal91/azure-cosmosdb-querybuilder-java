package com.github.psyduck.cosmosdbqueryutils;

import com.github.psyduck.cosmosdbqueryutils.models.Columns;
import com.github.psyduck.cosmosdbqueryutils.models.Order;
import com.github.psyduck.cosmosdbqueryutils.restriction.GroupedRestriction;
import com.github.psyduck.cosmosdbqueryutils.utilities.Constants;
import com.github.psyduck.cosmosdbqueryutils.utilities.RestrictionHelper;
import com.github.psyduck.cosmosdbqueryutils.restriction.Restriction;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.github.psyduck.cosmosdbqueryutils.restriction.Restriction.filterRestrictions;

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
        queryBuilder.append(Constants.GENERAL.SELECT);
        if(isCount){
            processCount();
        } else {
            processLimit();
            processColumns();
        }
        processFrom();
        processRestrictions();
        processOrder();

        return queryBuilder.toString().trim().replaceAll("( )+", " ");
    }

    private void processCount() {
        queryBuilder.append(Constants.GENERAL.VALUE_COUNT);
    }

    private void processOrder() {
        Optional.ofNullable(order).ifPresent(order ->
            queryBuilder.append(Constants.GENERAL.ORDER_BY)
                    .append(Constants.GENERAL.ALIAS)
                    .append(Constants.GENERAL.DOT)
                    .append(order.getParameterName())
                    .append(order.getOrder().getName())
        );
    }

    private void processRestrictions() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        filterRestrictions(this.restrictions);
        if(this.restrictions.size() > 0){
            queryBuilder.append(Constants.GENERAL.WHERE);
            Restriction.appendGroupedRestrictions(restrictions, queryBuilder);
        }
    }

    private void processFrom() {
        queryBuilder.append(Constants.GENERAL.FROM)
                .append(Constants.GENERAL.ALIAS);
    }

    private void processLimit() {
        Optional.ofNullable(limit).ifPresent(limit -> {
            queryBuilder.append(Constants.GENERAL.TOP).append(limit);
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
            queryBuilder.append(Constants.GENERAL.COMMA);
        }
        appendColumnToQuery(this.columns.getColumns().get(i), getAlias(i));
    }

    private void appendColumn() {
        if(this.columns.getColumns().get(0).equalsIgnoreCase(Constants.GENERAL.ALL)){
            queryBuilder.append(Constants.GENERAL.ALL);
        } else {
            appendColumnToQuery(this.columns.getColumns().get(0), getAlias(0));
        }
    }

    private Optional<String> getAlias(int i) {
        return this.columns.getAlias().size() > i ? Optional.ofNullable(this.columns.getAlias().get(i)) : Optional.empty();
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
            RestrictionHelper.getLastElementFromList(this.restrictions).setLogicalCombiner(Constants.Operators.Logical.OR);
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
