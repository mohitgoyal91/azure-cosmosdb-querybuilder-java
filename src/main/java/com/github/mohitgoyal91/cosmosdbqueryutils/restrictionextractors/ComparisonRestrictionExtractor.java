package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

/**
 * The interface Comparison restriction extractor.
 */
public interface ComparisonRestrictionExtractor {
    /**
     * Eq t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param value        the value
     * @return the t
     */
    <T> T eq(String propertyName, Object value);

    /**
     * Not eq t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param value        the value
     * @return the t
     */
    <T> T notEq(String propertyName, Object value);

    /**
     * Lt t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param value        the value
     * @return the t
     */
    <T> T lt(String propertyName, Object value);

    /**
     * Lte t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param value        the value
     * @return the t
     */
    <T> T lte(String propertyName, Object value);

    /**
     * Gt t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param value        the value
     * @return the t
     */
    <T> T gt(String propertyName, Object value);

    /**
     * Gte t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param value        the value
     * @return the t
     */
    <T> T gte(String propertyName, Object value);
}
