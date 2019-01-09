package com.psyduck.cosmosdbqueryutils;

import com.psyduck.cosmosdbqueryutils.restriction.Restriction;

public interface RestrictionInterface<T> {
    void addRestriction(String propertyName, Object value, String comparator);
    Restriction and();
    Restriction or();
}
