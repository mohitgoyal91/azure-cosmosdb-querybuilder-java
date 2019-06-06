package com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate;

/**
 * The interface Aggregate extractor min.
 */
public interface AggregateExtractorMin extends AggregateExtractor{
    /**
     * Count t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @return the t
     */
    <T> T count(String propertyName);
    <T> T count(String propertyName, String alias);

    /**
     * Min t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @return the t
     */
    <T> T min(String propertyName);

    /**
     * Min t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @return the t
     */
    <T> T min(String propertyName, String alias);

    /**
     * Max t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @return the t
     */
    <T> T max(String propertyName);

    /**
     * Max t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @return the t
     */
    <T> T max(String propertyName, String alias);

    /**
     * Sum t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @return the t
     */
    <T> T sum(String propertyName);

    /**
     * Sum t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @return the t
     */
    <T> T sum(String propertyName, String alias);

    /**
     * Avg t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @return the t
     */
    <T> T avg(String propertyName);

    /**
     * Avg t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @return the t
     */
    <T> T avg(String propertyName, String alias);
}
