package com.github.mohitgoyal91.cosmosdbqueryutils.utilities;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * The type Restriction helper.
 */
public class RestrictionHelper {

    /**
     * Handle expression append.
     *
     * @param <T>                   the type parameter
     * @param restrictionExpression the restriction expression
     * @param queryBuilder          the query builder
     * @throws NoSuchMethodException     the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     */
    public static <T> void handleExpressionAppend(T restrictionExpression, StringBuilder queryBuilder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        restrictionExpression
                .getClass()
                .getDeclaredMethod(Constants.FUNCTION.METHODNAMES.APPEND_RESTRICTION_EXCEPTION, restrictionExpression.getClass(), StringBuilder.class)
                .invoke(null, restrictionExpression, queryBuilder);
    }

    /**
     * Get last element from list t.
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return the t
     */
    public static <T> T getLastElementFromList(List<T> list){
        return list.get(list.size() - 1);
    }

    /**
     * Append value.
     *
     * @param value        the value
     * @param queryBuilder the query builder
     */
    public static void appendValue(Object value, StringBuilder queryBuilder) {
        boolean isString = false;
        if(value instanceof String){
            isString = true;
        }
        if(isString == true){
            queryBuilder.append(Constants.GENERAL.QUOTES_OPEN);
        }
        queryBuilder.append(value);
        if(isString == true){
            queryBuilder.append(Constants.GENERAL.QUOTES_CLOSED);
        }
    }
}
