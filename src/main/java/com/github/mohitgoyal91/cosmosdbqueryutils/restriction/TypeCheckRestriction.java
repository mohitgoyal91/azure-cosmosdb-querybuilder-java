package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions.TypeCheckRestrictionExpression;
import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors.TypeCheckRestrictionExtractor;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.FUNCTION.TYPECHECKING.IS_DEFINED;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Logical.NOT;

public class TypeCheckRestriction extends Restriction implements TypeCheckRestrictionExtractor {

    @Override
    public TypeCheckRestriction isDefined(String propertyName) {
        addRestriction(propertyName, null, IS_DEFINED);
        return this;
    }

    @Override
    public TypeCheckRestriction isNotDefined(String propertyName) {
        addRestriction(propertyName, null, NOT + IS_DEFINED);
        return this;
    }

    @Override
    public void addRestriction(String propertyName, Object value, String comparator) {
        this.restrictionExpressionList.add(new TypeCheckRestrictionExpression(propertyName, value, comparator, Constants.Operators.Logical.AND));
    }

    @Override
    public TypeCheckRestriction and() {
        if(this.restrictionExpressionList.size() > 0){
            ((TypeCheckRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.AND);
        }
        return this;
    }

    @Override
    public TypeCheckRestriction or() {
        if(this.restrictionExpressionList.size() > 0){
            ((TypeCheckRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.OR);
        }
        return this;
    }
}
