package com.psyduck.cosmosdbqueryutils.restrictionexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.psyduck.cosmosdbqueryutils.utilities.Constants.GENERAL.ALIAS;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.GENERAL.CURLY_BRACKETS_REGEX;
import static com.psyduck.cosmosdbqueryutils.utilities.Constants.GENERAL.DOT;

public class ArithmeticRestrictionExpression extends RestrictionExpression{

    public ArithmeticRestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner){
        super(propertyName, value, operation, logicalCombiner);
    }

    public ArithmeticRestrictionExpression(ComparisonRestrictionExpression previousExpression, String nextLogicalCombiner){
        super(previousExpression, nextLogicalCombiner);
    }

    public static void appendRestrictionExpression(ArithmeticRestrictionExpression restrictionExpression, StringBuilder queryBuilder){
        List<Object> values = (ArrayList<Object>)restrictionExpression.getValue();
        String expression = getUpdatedExpression(restrictionExpression, values.get(0));
        queryBuilder.append(expression)
                .append(restrictionExpression.getOperation())
                .append(values.get(1));
    }

    private static String getUpdatedExpression(ArithmeticRestrictionExpression restrictionExpression, Object value) {
        String expression = restrictionExpression.getPropertyName();
        List<Object> parameters = Arrays.asList((Object[])value);
        for(Object _value : parameters){
            if(_value instanceof String){
                expression = expression.replaceFirst(CURLY_BRACKETS_REGEX, getQueryParameter((String)_value));
            } else {
                expression = expression.replaceFirst(CURLY_BRACKETS_REGEX, _value.toString());
            }
        }
        return expression;
    }

    private static String getQueryParameter(String propertyName) {
        return new String(ALIAS + DOT + propertyName);
    }
}
