package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

public interface ComparisonRestrictionExtractor {
    <T> T eq(String propertyName, Object value);
    <T> T notEq(String propertyName, Object value);
    <T> T lt(String propertyName, Object value);
    <T> T lte(String propertyName, Object value);
    <T> T gt(String propertyName, Object value);
    <T> T gte(String propertyName, Object value);
}
