package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.Restriction;

/**
 * The interface Restriction interface.
 *
 * @param <T> the type parameter
 */
public interface RestrictionInterface<T> {
    /**
     * And restriction.
     *
     * @return the restriction
     */
    Restriction and();

    /**
     * Or restriction.
     *
     * @return the restriction
     */
    Restriction or();
}
