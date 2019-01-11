package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions.ArithmeticRestrictionExpression;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticRestriction extends Restriction{

    public ArithmeticRestriction eq(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), Constants.Operators.Comparison.EQUAL);
        return this;
    }

    public ArithmeticRestriction notEq(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), Constants.Operators.Comparison.NOT_EQUAL);
        return this;
    }

    public ArithmeticRestriction lt(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), Constants.Operators.Comparison.LESS_THAN);
        return this;
    }

    public ArithmeticRestriction lte(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), Constants.Operators.Comparison.LESS_THAN_EQUAL);
        return this;
    }

    public ArithmeticRestriction gt(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), Constants.Operators.Comparison.GREATER_THAN);
        return this;
    }

    public ArithmeticRestriction gte(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), Constants.Operators.Comparison.GREATER_THAN_EQUAL);
        return this;
    }

    private Object updatedValue(Double value, Object[] parameters) {
        List<Object> values = new ArrayList<>();
        values.add(parameters);
        values.add(value);
        return values;
    }

    @Override
    public void addRestriction(String propertyName, Object value, String comparator) {
        this.restrictionExpressionList.add(new ArithmeticRestrictionExpression(propertyName, value, comparator, Constants.Operators.Logical.AND));
    }

    @Override
    public ArithmeticRestriction and() {
        if(this.restrictionExpressionList.size() > 0){
            ((ArithmeticRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.AND);
        }
        return this;
    }

    @Override
    public Restriction or() {
        if(this.restrictionExpressionList.size() > 0){
            ((ArithmeticRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.OR);
        }
        return this;
    }
}
