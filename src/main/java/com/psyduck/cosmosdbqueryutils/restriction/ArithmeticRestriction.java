package com.psyduck.cosmosdbqueryutils.restriction;

import com.psyduck.cosmosdbqueryutils.restrictionexpressions.ArithmeticRestrictionExpression;
import com.psyduck.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.ArrayList;
import java.util.List;

import static com.psyduck.cosmosdbqueryutils.utilities.Constants.Operators.Comparison.*;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.Operators.Comparison.GREATER_THAN;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.Operators.Comparison.GREATER_THAN_EQUAL;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.Operators.Logical.AND;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.Operators.Logical.OR;

public class ArithmeticRestriction extends Restriction{

    public ArithmeticRestriction eq(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), EQUAL);
        return this;
    }

    public ArithmeticRestriction notEq(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), NOT_EQUAL);
        return this;
    }

    public ArithmeticRestriction lt(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), LESS_THAN);
        return this;
    }

    public ArithmeticRestriction lte(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), LESS_THAN_EQUAL);
        return this;
    }

    public ArithmeticRestriction gt(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), GREATER_THAN);
        return this;
    }

    public ArithmeticRestriction gte(Double value, String expression, Object... parameters){
        addRestriction(expression, updatedValue(value, parameters), GREATER_THAN_EQUAL);
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
        this.restrictionExpressionList.add(new ArithmeticRestrictionExpression(propertyName, value, comparator, AND));
    }

    @Override
    public ArithmeticRestriction and() {
        if(this.restrictionExpressionList.size() > 0){
            ((ArithmeticRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(AND);
        }
        return this;
    }

    @Override
    public Restriction or() {
        if(this.restrictionExpressionList.size() > 0){
            ((ArithmeticRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(OR);
        }
        return this;
    }
}
