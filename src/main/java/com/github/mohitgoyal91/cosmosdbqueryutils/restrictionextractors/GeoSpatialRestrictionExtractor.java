package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;

/**
 * The interface Geo spatial restriction extractor.
 */
public interface GeoSpatialRestrictionExtractor {
    /**
     * Eq t.
     *
     * @param <T>              the type parameter
     * @param propertyName     the property name
     * @param geoSpatialObject the geo spatial object
     * @param value            the value
     * @return the t
     */
    <T> T eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value);

    /**
     * Not eq t.
     *
     * @param <T>              the type parameter
     * @param propertyName     the property name
     * @param geoSpatialObject the geo spatial object
     * @param value            the value
     * @return the t
     */
    <T> T notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value);

    /**
     * Lt t.
     *
     * @param <T>              the type parameter
     * @param propertyName     the property name
     * @param geoSpatialObject the geo spatial object
     * @param value            the value
     * @return the t
     */
    <T> T lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value);

    /**
     * Lte t.
     *
     * @param <T>              the type parameter
     * @param propertyName     the property name
     * @param geoSpatialObject the geo spatial object
     * @param value            the value
     * @return the t
     */
    <T> T lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value);

    /**
     * Gt t.
     *
     * @param <T>              the type parameter
     * @param propertyName     the property name
     * @param geoSpatialObject the geo spatial object
     * @param value            the value
     * @return the t
     */
    <T> T gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value);

    /**
     * Gte t.
     *
     * @param <T>              the type parameter
     * @param propertyName     the property name
     * @param geoSpatialObject the geo spatial object
     * @param value            the value
     * @return the t
     */
    <T> T gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value);

    /**
     * Within t.
     *
     * @param <T>              the type parameter
     * @param propertyName     the property name
     * @param geoSpatialObject the geo spatial object
     * @return the t
     */
    <T> T within(String propertyName, GeoSpatialObject geoSpatialObject);
}
