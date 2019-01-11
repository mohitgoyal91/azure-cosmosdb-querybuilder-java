package com.github.mohitgoyal91.cosmosdbqueryutils.utilities;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class RestrictionHelper {

    public static <T> void handleExpressionAppend(T restrictionExpression, StringBuilder queryBuilder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        restrictionExpression
                .getClass()
                .getDeclaredMethod(Constants.FUNCTION.METHODNAMES.APPEND_RESTRICTION_EXCEPTION, restrictionExpression.getClass(), StringBuilder.class)
                .invoke(null, restrictionExpression, queryBuilder);
    }

    public static <T> T getLastElementFromList(List<T> list){
        return list.get(list.size() - 1);
    }

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
