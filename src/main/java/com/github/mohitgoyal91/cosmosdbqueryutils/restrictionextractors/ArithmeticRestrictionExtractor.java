package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

public interface ArithmeticRestrictionExtractor {
    <T> T eq(Double value, String expression, Object... parameters);
    <T> T notEq(Double value, String expression, Object... parameters);
    <T> T lt(Double value, String expression, Object... parameters);
    <T> T lte(Double value, String expression, Object... parameters);
    <T> T gt(Double value, String expression, Object... parameters);
    <T> T gte(Double value, String expression, Object... parameters);
}
