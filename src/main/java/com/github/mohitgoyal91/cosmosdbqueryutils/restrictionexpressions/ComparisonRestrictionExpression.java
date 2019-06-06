package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

/**
 * The type Comparison restriction expression.
 */
public class ComparisonRestrictionExpression extends RestrictionExpression{

    /**
     * Instantiates a new Comparison restriction expression.
     *
     * @param propertyName    the property name
     * @param value           the value
     * @param operation       the operation
     * @param logicalCombiner the logical combiner
     */
    public ComparisonRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    /**
     * Instantiates a new Comparison restriction expression.
     *
     * @param previousExpression  the previous expression
     * @param nextLogicalCombiner the next logical combiner
     */
    public ComparisonRestrictionExpression(ComparisonRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    /**
     * Append restriction expression.
     *
     * @param restrictionExpression the restriction expression
     * @param queryBuilder          the query builder
     */
    public static void appendRestrictionExpression(ComparisonRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        queryBuilder.append(Constants.GENERAL.ALIAS).append(Constants.GENERAL.DOT)
                .append(restrictionExpression.getPropertyName())
                .append(restrictionExpression.getOperation());
        RestrictionHelper.appendValue(restrictionExpression.getValue(), queryBuilder);
    }
}
