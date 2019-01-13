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

    @Override
    public ComparisonRestriction id(String id) {
        return eq(Constants.GENERAL.ID, id);
    }

    @Override
    public INRestriction in(String propertyName, Object... values) {
        return new INRestriction().in(propertyName, values);
    }

    @Override
    public ComparisonRestriction eq(String propertyName, Object value) {
        return new ComparisonRestriction().eq(propertyName, value);
    }

    @Override
    public ComparisonRestriction notEq(String propertyName, Object value) {
        return new ComparisonRestriction().notEq(propertyName, value);
    }

    @Override
    public ComparisonRestriction lt(String propertyName, Object value) {
        return new ComparisonRestriction().lt(propertyName, value);
    }

    @Override
    public ComparisonRestriction lte(String propertyName, Object value) {
        return new ComparisonRestriction().lte(propertyName, value);
    }

    @Override
    public ComparisonRestriction gt(String propertyName, Object value) {
        return new ComparisonRestriction().gt(propertyName, value);
    }

    @Override
    public ComparisonRestriction gte(String propertyName, Object value) {
        return new ComparisonRestriction().gte(propertyName, value);
    }

    @Override
    public ArithmeticRestriction eq(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().eq(value, expression, parameters);
    }

    @Override
    public ArithmeticRestriction notEq(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().notEq(value, expression, parameters);
    }

    @Override
    public ArithmeticRestriction lt(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().lt(value, expression, parameters);
    }

    @Override
    public ArithmeticRestriction lte(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().lte(value, expression, parameters);
    }

    @Override
    public ArithmeticRestriction gt(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().gt(value, expression, parameters);
    }

    @Override
    public ArithmeticRestriction gte(Double value, String expression, Object... parameters) {
        return new ArithmeticRestriction().gte(value, expression, parameters);
    }

    @Override
    public GeoSpatialRestriction eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().eq(propertyName, geoSpatialObject, value);
    }

    @Override
    public GeoSpatialRestriction notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().notEq(propertyName, geoSpatialObject, value);
    }

    @Override
    public GeoSpatialRestriction lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().lt(propertyName, geoSpatialObject, value);
    }

    @Override
    public GeoSpatialRestriction lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().lte(propertyName, geoSpatialObject, value);
    }

    @Override
    public GeoSpatialRestriction gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().gt(propertyName, geoSpatialObject, value);
    }

    @Override
    public GeoSpatialRestriction gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return new GeoSpatialRestriction().gte(propertyName, geoSpatialObject, value);
    }

    @Override
    public GeoSpatialRestriction within(String propertyName, GeoSpatialObject geoSpatialObject) {
        return new GeoSpatialRestriction().within(propertyName, geoSpatialObject);
    }
}
