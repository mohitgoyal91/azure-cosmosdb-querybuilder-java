package com.psyduck.cosmosdbqueryutils.restrictionexpressions;

import com.psyduck.cosmosdbqueryutils.models.GeoSpatialObject;
import com.psyduck.cosmosdbqueryutils.utilities.Constants;

import java.util.Optional;

public class GeoSpatialRestrictionExpression extends RestrictionExpression{

    public GeoSpatialRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    public GeoSpatialRestrictionExpression(ComparisonRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

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
