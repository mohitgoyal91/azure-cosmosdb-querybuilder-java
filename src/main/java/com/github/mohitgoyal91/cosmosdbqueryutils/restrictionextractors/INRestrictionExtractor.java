package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

public interface INRestrictionExtractor {
    <T> T in(String propertyName, Object... values);
}
