package com.github.mohitgoyal91.cosmosdbqueryutils;

/**
 * The interface Add restriction interface.
 */
public interface AddRestrictionInterface {
    /**
     * Add restriction.
     *
     * @param propertyName the property name
     * @param value        the value
     * @param comparator   the comparator
     */
    void addRestriction(String propertyName, Object value, String comparator);
}
