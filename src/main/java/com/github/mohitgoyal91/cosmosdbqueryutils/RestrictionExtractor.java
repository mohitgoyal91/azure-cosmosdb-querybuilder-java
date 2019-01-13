package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;

import java.util.List;

public interface RestrictionExtractor {
    <T> T id(String id);
    <T> T in(String propertyName, Object... values);
    <T> T eq(String propertyName, Object value);
    <T> T notEq(String propertyName, Object value);
    <T> T lt(String propertyName, Object value);
    <T> T lte(String propertyName, Object value);
    <T> T gt(String propertyName, Object value);
    <T> T gte(String propertyName, Object value);
    <T> T eq(Double value, String expression, Object... parameters);
    <T> T notEq(Double value, String expression, Object... parameters);
    <T> T lt(Double value, String expression, Object... parameters);
    <T> T lte(Double value, String expression, Object... parameters);
    <T> T gt(Double value, String expression, Object... parameters);
    <T> T gte(Double value, String expression, Object... parameters);
    <T> T eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T within(String propertyName, GeoSpatialObject geoSpatialObject);
}
