package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

public interface ArrayFunctionsExtractor {
    <T> T arrayContains(String propertyName, Object value);
}
