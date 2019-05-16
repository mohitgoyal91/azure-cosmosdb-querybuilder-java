package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

public interface TypeCheckRestrictionExtractor {
    <T> T isDefined(String propertyName);
    <T> T isNotDefined(String propertyName);
}
