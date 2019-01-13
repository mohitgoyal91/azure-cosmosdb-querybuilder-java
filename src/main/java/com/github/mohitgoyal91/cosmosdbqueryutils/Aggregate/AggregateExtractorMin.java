package com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate;

public interface AggregateExtractorMin extends AggregateExtractor{
    <T> T count(String propertyName);
    <T> T count(String propertyName, String alias);
    <T> T min(String propertyName);
    <T> T min(String propertyName, String alias);
    <T> T max(String propertyName);
    <T> T max(String propertyName, String alias);
    <T> T sum(String propertyName);
    <T> T sum(String propertyName, String alias);
    <T> T avg(String propertyName);
    <T> T avg(String propertyName, String alias);
}
