package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.GENERAL.*;

public class ArrayRestrictionExpression extends RestrictionExpression {

    public ArrayRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    public ArrayRestrictionExpression(ArrayRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    public static void appendRestrictionExpression(ArrayRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        queryBuilder.append(restrictionExpression.getOperation()).append(BRACKET_OPEN)
                .append(ALIAS).append(DOT).append(restrictionExpression.getPropertyName()).append(COMMA);
        RestrictionHelper.appendValue(restrictionExpression.getValue(), queryBuilder);
    }
}
