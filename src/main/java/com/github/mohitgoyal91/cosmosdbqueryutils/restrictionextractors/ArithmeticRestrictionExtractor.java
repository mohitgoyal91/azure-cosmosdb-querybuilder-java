package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors;

/**
 * The interface Arithmetic restriction extractor.
 */
public interface ArithmeticRestrictionExtractor {
    /**
     * Eq t.
     *
     * @param <T>        the type parameter
     * @param value      the value
     * @param expression the expression
     * @param parameters the parameters
     * @return the t
     */
    <T> T eq(Double value, String expression, Object... parameters);

    /**
     * Not eq t.
     *
     * @param <T>        the type parameter
     * @param value      the value
     * @param expression the expression
     * @param parameters the parameters
     * @return the t
     */
    <T> T notEq(Double value, String expression, Object... parameters);

    /**
     * Lt t.
     *
     * @param <T>        the type parameter
     * @param value      the value
     * @param expression the expression
     * @param parameters the parameters
     * @return the t
     */
    <T> T lt(Double value, String expression, Object... parameters);

    /**
     * Lte t.
     *
     * @param <T>        the type parameter
     * @param value      the value
     * @param expression the expression
     * @param parameters the parameters
     * @return the t
     */
    <T> T lte(Double value, String expression, Object... parameters);

    /**
     * Gt t.
     *
     * @param <T>        the type parameter
     * @param value      the value
     * @param expression the expression
     * @param parameters the parameters
     * @return the t
     */
    <T> T gt(Double value, String expression, Object... parameters);

    /**
     * Gte t.
     *
     * @param <T>        the type parameter
     * @param value      the value
     * @param expression the expression
     * @param parameters the parameters
     * @return the t
     */
    <T> T gte(Double value, String expression, Object... parameters);
}
