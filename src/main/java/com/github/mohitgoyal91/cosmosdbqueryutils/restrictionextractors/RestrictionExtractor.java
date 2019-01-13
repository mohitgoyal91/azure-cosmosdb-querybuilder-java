package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;

import java.util.List;

public interface RestrictionExtractor {
    <T> T id(String id);
}
