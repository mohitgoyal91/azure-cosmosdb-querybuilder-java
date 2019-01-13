package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions.ArrayRestrictionExpression;
import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors.ArrayFunctionsExtractor;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.Optional;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.FUNCTION.ARRAYTYPE.ARRAY_CONTAINS;

public class ArrayRestriction extends Restriction implements ArrayFunctionsExtractor {

    @Override
    public ArrayRestriction arrayContains(String propertyName, Object value) {
        addRestriction(propertyName, value, ARRAY_CONTAINS);
        return this;
    }

    @Override
    public void addRestriction(String propertyName, Object value, String comparator) {
        if(value instanceof Optional){
            if(((Optional) value).isPresent()){
                this.restrictionExpressionList.add(new ArrayRestrictionExpression(propertyName, ((Optional) value).get(), comparator, Constants.Operators.Logical.AND));
            }
        } else {
            this.restrictionExpressionList.add(new ArrayRestrictionExpression(propertyName, value, comparator, Constants.Operators.Logical.AND));
        }
    }

    @Override
    public ArrayRestriction and() {
        if(this.restrictionExpressionList.size() > 0){
            ((ArrayRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.AND);
        }
        return this;
    }

    @Override
    public ArrayRestriction or() {
        if(this.restrictionExpressionList.size() > 0){
            ((ArrayRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.OR);
        }
        return this;
    }
}
