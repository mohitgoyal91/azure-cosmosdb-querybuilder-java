package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

public abstract class RestrictionExtractor implements ComparisonRestrictionExtractor, ArithmeticRestrictionExtractor
        , INRestrictionExtractor, GeoSpatialRestrictionExtractor {
    public abstract <T> T id(String id);
}
