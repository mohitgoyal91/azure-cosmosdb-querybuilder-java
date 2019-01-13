package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions.ComparisonRestrictionExpression;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.Optional;

public class ComparisonRestriction extends Restriction {

    /**
     * To introduce a = restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of ComparisonRestriction
     */
    public ComparisonRestriction eq(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.EQUAL);
        return this;
    }

    /**
     * To introduce a != restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of ComparisonRestriction
     */
    public ComparisonRestriction notEq(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.NOT_EQUAL);
        return this;
    }

    /**
     * To introduce a < restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of ComparisonRestriction
     */
    public ComparisonRestriction lt(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.LESS_THAN);
        return this;
    }

    /**
     * To introduce a <= restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of ComparisonRestriction
     */
    public ComparisonRestriction lte(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.LESS_THAN_EQUAL);
        return this;
    }

    /**
     * To introduce a > restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of ComparisonRestriction
     */
    public ComparisonRestriction gt(String propertyName, Object value){
        addRestriction(propertyName, value, Constants.Operators.Comparison.GREATER_THAN);
        return this;
    }

    /**
     * To introduce a >= restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of ComparisonRestriction
     */
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

    /**
     * to separate the previous and next restrictions by an 'AND'
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction and(){
        if(this.restrictionExpressionList.size() > 0){
            ((ComparisonRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.AND);
        }
        return this;
    }

    /**
     * to separate the previous and next restrictions by an 'OR'
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction or(){
        if(this.restrictionExpressionList.size() > 0){
            ((ComparisonRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.OR);
        }
        return this;
    }
}
