package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

/**
 * The interface Array functions extractor.
 */
public interface ArrayFunctionsExtractor {
    /**
     * Array contains t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param value        the value
     * @return the t
     */
    <T> T arrayContains(String propertyName, Object value);
}
