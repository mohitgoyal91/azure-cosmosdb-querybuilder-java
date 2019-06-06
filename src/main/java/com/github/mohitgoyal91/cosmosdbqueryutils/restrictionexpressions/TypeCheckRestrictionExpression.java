package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

/**
 * The type Type check restriction expression.
 */
public class TypeCheckRestrictionExpression extends RestrictionExpression {

    /**
     * Instantiates a new Type check restriction expression.
     *
     * @param propertyName    the property name
     * @param value           the value
     * @param operation       the operation
     * @param logicalCombiner the logical combiner
     */
    public TypeCheckRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    /**
     * Instantiates a new Type check restriction expression.
     *
     * @param previousExpression  the previous expression
     * @param nextLogicalCombiner the next logical combiner
     */
    public TypeCheckRestrictionExpression(TypeCheckRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    /**
     * Append restriction expression.
     *
     * @param restrictionExpression the restriction expression
     * @param queryBuilder          the query builder
     */
    public static void appendRestrictionExpression(TypeCheckRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        queryBuilder.append(restrictionExpression.getOperation())
                .append(Constants.GENERAL.BRACKET_OPEN)
                .append(Constants.GENERAL.ALIAS).append(Constants.GENERAL.DOT)
                .append(restrictionExpression.getPropertyName())
                .append(Constants.GENERAL.BRACKET_CLOSED);
    }
}
