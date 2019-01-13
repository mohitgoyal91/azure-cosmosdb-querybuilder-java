package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.Restriction;

public interface RestrictionInterface<T> {
    Restriction and();
    Restriction or();
}
