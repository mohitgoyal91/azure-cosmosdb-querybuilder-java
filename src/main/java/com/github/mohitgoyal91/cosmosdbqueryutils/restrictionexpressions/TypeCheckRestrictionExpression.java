package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

public class TypeCheckRestrictionExpression extends RestrictionExpression {

    public TypeCheckRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    public TypeCheckRestrictionExpression(TypeCheckRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    public static void appendRestrictionExpression(TypeCheckRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        queryBuilder.append(restrictionExpression.getOperation())
                .append(Constants.GENERAL.BRACKET_OPEN)
                .append(Constants.GENERAL.ALIAS).append(Constants.GENERAL.DOT)
                .append(restrictionExpression.getPropertyName())
                .append(Constants.GENERAL.BRACKET_CLOSED);
    }
}
