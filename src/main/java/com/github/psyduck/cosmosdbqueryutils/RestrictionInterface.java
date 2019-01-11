package com.github.psyduck.cosmosdbqueryutils;

import com.github.psyduck.cosmosdbqueryutils.restriction.Restriction;

public interface RestrictionInterface<T> {
    void addRestriction(String propertyName, Object value, String comparator);
    Restriction and();
    Restriction or();
}
