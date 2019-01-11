package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions.GeoSpatialRestrictionExpression;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.FUNCTION.GEOSPATIAL.*;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Comparison.*;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Logical.AND;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Logical.OR;

public class GeoSpatialRestriction extends Restriction {

    public GeoSpatialRestriction distanceEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, EQUAL);
        return this;
    }

    public GeoSpatialRestriction distanceNotEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, NOT_EQUAL);
        return this;
    }

    public GeoSpatialRestriction distanceLt(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, LESS_THAN);
        return this;
    }

    public GeoSpatialRestriction distanceLte(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, LESS_THAN_EQUAL);
        return this;
    }

    public GeoSpatialRestriction distanceGt(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, GREATER_THAN);
        return this;
    }

    public GeoSpatialRestriction distanceGte(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, GREATER_THAN_EQUAL);
        return this;
    }

    public GeoSpatialRestriction within(String propertyName, GeoSpatialObject geoSpatialObject){
        updateFunction(geoSpatialObject, ST_WITHIN);
        addRestriction(propertyName, geoSpatialObject, null);
        return this;
    }

    /*public GeoSpatialRestriction intersects(GeoSpatialObject geoSpatialObject1, GeoSpatialObject geoSpatialObject2){
        updateFunction(geoSpatialObject1, ST_INTERSECTS);
        updateFunction(geoSpatialObject2, ST_INTERSECTS);
        addRestriction(null, new GeoSpatialObject[]{geoSpatialObject1, geoSpatialObject2}, null);
        return this;
    }

    public GeoSpatialRestriction overlaps(GeoSpatialObject geoSpatialObject1, GeoSpatialObject geoSpatialObject2){
        updateFunction(geoSpatialObject1, ST_OVERLAPS);
        updateFunction(geoSpatialObject2, ST_OVERLAPS);
        addRestriction(null, new GeoSpatialObject[]{geoSpatialObject1, geoSpatialObject2}, null);
        return this;
    }*/

    private void updateFunction(GeoSpatialObject geoSpatialObject, String functionName) {
        geoSpatialObject.setFunctionName(functionName);
    }

    private void updateFunctionAndValue(GeoSpatialObject geoSpatialObject, Double value, String functionName) {
        geoSpatialObject.setFunctionName(functionName);
        geoSpatialObject.setValue(value);
    }

    @Override
    public void addRestriction(String propertyName, Object value, String comparator) {
        this.restrictionExpressionList.add(new GeoSpatialRestrictionExpression(propertyName, value, comparator, AND));
    }

    @Override
    public GeoSpatialRestriction and() {
        if(this.restrictionExpressionList.size() > 0){
            ((GeoSpatialRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(AND);
        }
        return this;
    }

    @Override
    public GeoSpatialRestriction or() {
        if(this.restrictionExpressionList.size() > 0){
            ((GeoSpatialRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(OR);
        }
        return this;
    }
}
