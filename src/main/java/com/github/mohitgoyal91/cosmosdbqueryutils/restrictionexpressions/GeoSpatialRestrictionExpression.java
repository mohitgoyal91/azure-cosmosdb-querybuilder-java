package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.Optional;

/**
 * The type Geo spatial restriction expression.
 */
public class GeoSpatialRestrictionExpression extends RestrictionExpression{

    /**
     * Instantiates a new Geo spatial restriction expression.
     *
     * @param propertyName    the property name
     * @param value           the value
     * @param operation       the operation
     * @param logicalCombiner the logical combiner
     */
    public GeoSpatialRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    /**
     * Instantiates a new Geo spatial restriction expression.
     *
     * @param previousExpression  the previous expression
     * @param nextLogicalCombiner the next logical combiner
     */
    public GeoSpatialRestrictionExpression(ComparisonRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    /**
     * Append restriction expression.
     *
     * @param restrictionExpression the restriction expression
     * @param queryBuilder          the query builder
     */
    public static void appendRestrictionExpression(GeoSpatialRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        GeoSpatialObject geoSpatialObject = ((GeoSpatialObject)restrictionExpression.getValue());

        queryBuilder.append(geoSpatialObject.getFunctionName());
        queryBuilder.append(Constants.GENERAL.BRACKET_OPEN);
        appendProperty(restrictionExpression, queryBuilder);
        appendCoordinateObject(geoSpatialObject, queryBuilder);
        queryBuilder.append(Constants.GENERAL.BRACKET_CLOSED);

        appendValue(geoSpatialObject, restrictionExpression.getOperation(), queryBuilder);
    }

    private static void appendProperty(GeoSpatialRestrictionExpression restrictionExpression, StringBuilder queryBuilder) {
        if(Optional.ofNullable(restrictionExpression.getPropertyName()).isPresent()){
            queryBuilder.append(Constants.GENERAL.ALIAS).append(Constants.GENERAL.DOT)
                    .append(restrictionExpression.getPropertyName())
                    .append(Constants.GENERAL.COMMA);
        }
    }

    private static void appendCoordinateObject(GeoSpatialObject geoSpatialObject, StringBuilder queryBuilder) {
        queryBuilder.append(geoSpatialObject.toString());
    }

    private static void appendValue(GeoSpatialObject geoSpatialObject, String operation, StringBuilder queryBuilder) {
        if(Optional.ofNullable(geoSpatialObject.getValue()).isPresent()){
            queryBuilder.append(operation);
            queryBuilder.append(geoSpatialObject.getValue());
        }
    }
}
