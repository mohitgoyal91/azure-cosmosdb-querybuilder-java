package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * The type In restriction expression.
 */
public class INRestrictionExpression extends RestrictionExpression{

    /**
     * Instantiates a new In restriction expression.
     *
     * @param propertyName    the property name
     * @param value           the value
     * @param operation       the operation
     * @param logicalCombiner the logical combiner
     */
    public INRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    /**
     * Instantiates a new In restriction expression.
     *
     * @param previousExpression  the previous expression
     * @param nextLogicalCombiner the next logical combiner
     */
    public INRestrictionExpression(INRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    /**
     * Append restriction expression.
     *
     * @param restrictionExpression the restriction expression
     * @param queryBuilder          the query builder
     */
    public static void appendRestrictionExpression(INRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        queryBuilder.append(Constants.GENERAL.ALIAS).append(Constants.GENERAL.DOT)
                .append(restrictionExpression.getPropertyName())
                .append(restrictionExpression.getOperation());
        List<Object> values = (ArrayList<Object>)restrictionExpression.getValue();
        queryBuilder.append(Constants.GENERAL.BRACKET_OPEN);
        int i;
        for(i = 0; i < values.size() - 1; i++){
            RestrictionHelper.appendValue(values.get(i), queryBuilder);
            queryBuilder.append(Constants.GENERAL.COMMA);
        }
        RestrictionHelper.appendValue(values.get(i), queryBuilder);
        queryBuilder.append(Constants.GENERAL.BRACKET_CLOSED);
    }
}
