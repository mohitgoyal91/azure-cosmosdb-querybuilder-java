package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

/**
 * The interface In restriction extractor.
 */
public interface INRestrictionExtractor {
    /**
     * In t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param values       the values
     * @return the t
     */
    <T> T in(String propertyName, Object... values);
}
