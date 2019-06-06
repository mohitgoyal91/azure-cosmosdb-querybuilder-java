package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.GENERAL.*;

/**
 * The type Array restriction expression.
 */
public class ArrayRestrictionExpression extends RestrictionExpression {

    /**
     * Instantiates a new Array restriction expression.
     *
     * @param propertyName    the property name
     * @param value           the value
     * @param operation       the operation
     * @param logicalCombiner the logical combiner
     */
    public ArrayRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    /**
     * Instantiates a new Array restriction expression.
     *
     * @param previousExpression  the previous expression
     * @param nextLogicalCombiner the next logical combiner
     */
    public ArrayRestrictionExpression(ArrayRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    /**
     * Append restriction expression.
     *
     * @param restrictionExpression the restriction expression
     * @param queryBuilder          the query builder
     */
    public static void appendRestrictionExpression(ArrayRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        queryBuilder.append(restrictionExpression.getOperation()).append(BRACKET_OPEN)
                .append(ALIAS).append(DOT).append(restrictionExpression.getPropertyName()).append(COMMA);
        RestrictionHelper.appendValue(restrictionExpression.getValue(), queryBuilder);
    }
}
