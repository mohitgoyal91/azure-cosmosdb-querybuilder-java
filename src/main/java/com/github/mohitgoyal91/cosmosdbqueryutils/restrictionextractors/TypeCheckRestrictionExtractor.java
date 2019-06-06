package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

/**
 * The interface Type check restriction extractor.
 */
public interface TypeCheckRestrictionExtractor {
    /**
     * Is defined t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @return the t
     */
    <T> T isDefined(String propertyName);

    /**
     * Is not defined t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @return the t
     */
    <T> T isNotDefined(String propertyName);
}
