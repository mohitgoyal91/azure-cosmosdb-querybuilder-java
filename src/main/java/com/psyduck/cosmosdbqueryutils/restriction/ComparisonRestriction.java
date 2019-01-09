package com.psyduck.cosmosdbqueryutils.restriction;

import com.psyduck.cosmosdbqueryutils.restrictionexpressions.ComparisonRestrictionExpression;
import com.psyduck.cosmosdbqueryutils.utilities.Constants;
import com.psyduck.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.Optional;

public class ComparisonRestriction extends Restriction {

    public ComparisonRestriction eq(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.EQUAL);
        return this;
    }

    public ComparisonRestriction notEq(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.NOT_EQUAL);
        return this;
    }

    public ComparisonRestriction lt(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.LESS_THAN);
        return this;
    }

    public ComparisonRestriction lte(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.LESS_THAN_EQUAL);
        return this;
    }

    public ComparisonRestriction gt(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.GREATER_THAN);
        return this;
    }

    public ComparisonRestriction gte(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.GREATER_THAN_EQUAL);
        return this;
    }

    @Override
    public void addRestriction(String propertyName, Object value, String comparator) {
        if(value instanceof Optional){
            if(((Optional) value).isPresent()){
                this.restrictionExpressionList.add(new ComparisonRestrictionExpression(propertyName, ((Optional) value).get(), comparator, Constants.Operators.Logical.AND));
            }
        } else {
            this.restrictionExpressionList.add(new ComparisonRestrictionExpression(propertyName, value, comparator, Constants.Operators.Logical.AND));
        }
    }

    @Override
    public ComparisonRestriction and(){
        if(this.restrictionExpressionList.size() > 0){
            ((ComparisonRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.AND);
        }
        return this;
    }

    @Override
    public ComparisonRestriction or(){
        if(this.restrictionExpressionList.size() > 0){
            ((ComparisonRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.OR);
        }
        return this;
    }
}
