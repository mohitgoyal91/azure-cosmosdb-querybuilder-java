package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions.GeoSpatialRestrictionExpression;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.FUNCTION.GEOSPATIAL.*;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Comparison.*;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Logical.AND;
import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Logical.OR;

public class GeoSpatialRestriction extends Restriction {

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal =}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    public GeoSpatialRestriction eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, EQUAL);
        return this;
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal !=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    public GeoSpatialRestriction notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, NOT_EQUAL);
        return this;
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal <}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    public GeoSpatialRestriction lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, LESS_THAN);
        return this;
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal <=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    public GeoSpatialRestriction lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, LESS_THAN_EQUAL);
        return this;
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal >}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    public GeoSpatialRestriction gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, GREATER_THAN);
        return this;
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal >=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    public GeoSpatialRestriction gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value){
        updateFunctionAndValue(geoSpatialObject, value, ST_DISTANCE);
        addRestriction(propertyName, geoSpatialObject, GREATER_THAN_EQUAL);
        return this;
    }

    /**
     * To introduce a WITHIN restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @return current instance of GeoSpatialRestriction
     */
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

    /**
     * to separate the previous and next restrictions by an 'AND'
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction and() {
        if(this.restrictionExpressionList.size() > 0){
            ((GeoSpatialRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(AND);
        }
        return this;
    }

    /**
     * to separate the previous and next restrictions by an 'OR'
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction or() {
        if(this.restrictionExpressionList.size() > 0){
            ((GeoSpatialRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(OR);
        }
        return this;
    }
}
