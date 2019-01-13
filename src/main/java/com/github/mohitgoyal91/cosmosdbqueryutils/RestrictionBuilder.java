package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.ArithmeticRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.ComparisonRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.GeoSpatialRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.INRestriction;
import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors.*;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

public class RestrictionBuilder implements RestrictionExtractor, ComparisonRestrictionExtractor, ArithmeticRestrictionExtractor
        , INRestrictionExtractor, GeoSpatialRestrictionExtractor {

    /**
     * To create query with id restriction
     * @param id id of the document to be fetched
     * @return ComparisonRestriction
     */
    @Override
    public ComparisonRestriction id(String id) {
        return eq(Constants.GENERAL.ID, id);
    }

    /**
     * To introduce an in restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param values values separated by comma ','
     * @return current instance of INRestriction
     */
    @Override
    public INRestriction in(String propertyName, Object... values) {
        return new INRestriction().in(propertyName, values);
    }

    /**
     * To introduce a {@literal =} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction eq(String propertyName, Object value) {
        return new ComparisonRestriction().eq(propertyName, value);
    }

    /**
     * To introduce a {@literal !=} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction notEq(String propertyName, Object value) {
        return new ComparisonRestriction().notEq(propertyName, value);
    }

    /**
     * To introduce a {@literal <} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction lt(String propertyName, Object value) {
        return new ComparisonRestriction().lt(propertyName, value);
    }

    /**
     * To introduce a {@literal <=} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction lte(String propertyName, Object value) {
        return new ComparisonRestriction().lte(propertyName, value);
    }

    /**
     * To introduce a {@literal >} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction gt(String propertyName, Object value) {
        return new ComparisonRestriction().gt(propertyName, value);
    }

    /**
     * To introduce a {@literal >=} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of ComparisonRestriction
     */
    @Override
    public ComparisonRestriction gte(String propertyName, Object value) {
        return new ComparisonRestriction().gte(propertyName, value);
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal =}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of ArithmeticRestriction
     */
    @Override
    public ArithmeticRestriction eq(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().eq(value, expression, parameters);
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal !=}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of ArithmeticRestriction
     */
    @Override
    public ArithmeticRestriction notEq(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().notEq(value, expression, parameters);
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal <}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of ArithmeticRestriction
     */
    @Override
    public ArithmeticRestriction lt(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().lt(value, expression, parameters);
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal <=}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of ArithmeticRestriction
     */
    @Override
    public ArithmeticRestriction lte(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().lte(value, expression, parameters);
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal >}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of ArithmeticRestriction
     */
    @Override
    public ArithmeticRestriction gt(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().gt(value, expression, parameters);
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal >=}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of ArithmeticRestriction
     */
    @Override
    public ArithmeticRestriction gte(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().gte(value, expression, parameters);
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal =}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().eq(propertyName, geoSpatialObject, value);
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal !=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().notEq(propertyName, geoSpatialObject, value);
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal <}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().lt(propertyName, geoSpatialObject, value);
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal <=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().lte(propertyName, geoSpatialObject, value);
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal >}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().gt(propertyName, geoSpatialObject, value);
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal >=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().gte(propertyName, geoSpatialObject, value);
    }

    /**
     * To introduce a WITHIN restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @return current instance of GeoSpatialRestriction
     */
    @Override
    public GeoSpatialRestriction within(String propertyName, GeoSpatialObject geoSpatialObject) {
        return new GeoSpatialRestriction().within(propertyName, geoSpatialObject);
    }
}
