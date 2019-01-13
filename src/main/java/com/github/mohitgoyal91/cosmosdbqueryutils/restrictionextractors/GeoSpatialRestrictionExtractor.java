package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;

public interface GeoSpatialRestrictionExtractor {
    <T> T eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value);
    <T> T within(String propertyName, GeoSpatialObject geoSpatialObject);
}
