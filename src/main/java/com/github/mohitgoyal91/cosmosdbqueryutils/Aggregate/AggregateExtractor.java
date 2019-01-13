package com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate;

public interface AggregateExtractor {
    <T> T count(String propertyName, String alias, String udf);
    <T> T min(String propertyName, String alias, String udf);
    <T> T max(String propertyName, String alias, String udf);
    <T> T sum(String propertyName, String alias, String udf);
    <T> T avg(String propertyName, String alias, String udf);
}
