package com.psyduck.cosmosdbqueryutils.restrictionexpressions;

import com.psyduck.cosmosdbqueryutils.utilities.Constants;
import com.psyduck.cosmosdbqueryutils.utilities.RestrictionHelper;

public class ComparisonRestrictionExpression extends RestrictionExpression{

    public ComparisonRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    public ComparisonRestrictionExpression(ComparisonRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    public static void appendRestrictionExpression(ComparisonRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        queryBuilder.append(Constants.GENERAL.ALIAS).append(Constants.GENERAL.DOT)
                .append(restrictionExpression.getPropertyName())
                .append(restrictionExpression.getOperation());
        RestrictionHelper.appendValue(restrictionExpression.getValue(), queryBuilder);
    }
}
