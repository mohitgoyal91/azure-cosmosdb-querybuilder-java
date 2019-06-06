package com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate;

/**
 * The interface Aggregate extractor.
 */
public interface AggregateExtractor {
    /**
     * Count t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @return the t
     */
    <T> T count(String propertyName, String alias);

    /**
     * Min t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @param udf          the udf
     * @return the t
     */
    <T> T min(String propertyName, String alias, String udf);

    /**
     * Max t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @param udf          the udf
     * @return the t
     */
    <T> T max(String propertyName, String alias, String udf);

    /**
     * Sum t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @param udf          the udf
     * @return the t
     */
    <T> T sum(String propertyName, String alias, String udf);

    /**
     * Avg t.
     *
     * @param <T>          the type parameter
     * @param propertyName the property name
     * @param alias        the alias
     * @param udf          the udf
     * @return the t
     */
    <T> T avg(String propertyName, String alias, String udf);
}
