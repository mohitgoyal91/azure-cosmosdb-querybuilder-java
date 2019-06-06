package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

/**
 * The type Restriction extractor.
 */
public abstract class RestrictionExtractor implements ComparisonRestrictionExtractor, ArithmeticRestrictionExtractor
        , INRestrictionExtractor, GeoSpatialRestrictionExtractor, ArrayFunctionsExtractor, TypeCheckRestrictionExtractor {
    /**
     * Id t.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the t
     */
    public abstract <T> T id(String id);
}
