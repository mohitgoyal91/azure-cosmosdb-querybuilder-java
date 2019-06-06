package com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.GENERAL.*;

/**
 * The type Aggregate.
 */
public class Aggregate {

    /**
     * Append aggregate expression.
     *
     * @param aggregateFunction the aggregate function
     * @param queryBuilder      the query builder
     */
    public static void appendAggregateExpression(AggregateFunction aggregateFunction, StringBuilder queryBuilder) {
        queryBuilder.append(aggregateFunction.getAggregator())
                .append(BRACKET_OPEN);
        if(aggregateFunction.getUdf() != null){
            queryBuilder.append(UDF).append(DOT.trim())
                    .append(aggregateFunction.getUdf()).append(BRACKET_OPEN.trim());
        }
        queryBuilder.append(ALIAS).append(DOT).append(aggregateFunction.getPropertyName());
        if(aggregateFunction.getUdf() != null){
            queryBuilder.append(BRACKET_CLOSED);
        }
        queryBuilder.append(BRACKET_CLOSED).append(AS).append(aggregateFunction.getAlias());
    }
}
