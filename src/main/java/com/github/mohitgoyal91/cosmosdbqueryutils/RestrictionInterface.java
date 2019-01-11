package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.Restriction;

public interface RestrictionInterface<T> {
    void addRestriction(String propertyName, Object value, String comparator);
    Restriction and();
    Restriction or();
}
