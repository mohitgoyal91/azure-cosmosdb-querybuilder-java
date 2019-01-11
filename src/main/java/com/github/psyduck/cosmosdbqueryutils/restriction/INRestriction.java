package com.github.psyduck.cosmosdbqueryutils.restriction;

import com.github.psyduck.cosmosdbqueryutils.restrictionexpressions.INRestrictionExpression;
import com.github.psyduck.cosmosdbqueryutils.utilities.Constants;
import com.github.psyduck.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class INRestriction extends Restriction {

    public <T> INRestriction in(String propertyName, List<T> values){
        return in(propertyName, values.toArray());
    }

    public INRestriction in(String propertyName, Object... values){
        addRestriction(propertyName, values, Constants.Operators.Comparison.IN);
        return this;
    }

    @Override
    public void addRestriction(String propertyName, Object value, String comparator) {
        List<Object> values = Arrays.asList((Object [])value);
        values = values.stream().filter(_value -> {
                        if (_value instanceof Optional && !((Optional) _value).isPresent()) {
                            return false;
                        }
                        return true;
                    }).collect(Collectors.toList());

        if(!values.isEmpty()){
            this.restrictionExpressionList.add(new INRestrictionExpression(propertyName, values, comparator, Constants.Operators.Logical.AND));
        }
    }

    @Override
    public INRestriction and() {
        if(this.restrictionExpressionList.size() > 0){
            ((INRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.AND);
        }
        return this;
    }

    @Override
    public INRestriction or() {
        if(this.restrictionExpressionList.size() > 0){
            ((INRestrictionExpression) RestrictionHelper.getLastElementFromList(this.getRestrictionExpressionList())).setLogicalCombiner(Constants.Operators.Logical.OR);
        }
        return this;
    }
}
