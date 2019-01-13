package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.Arrays;
import java.util.List;

public class GroupedRestriction<T> {

    private List<T> restrictions;
    private String logicalCombiner = Constants.Operators.Logical.AND;

    public GroupedRestriction(T[] restrictions){
        this.restrictions = Arrays.asList(restrictions);
    }

    public GroupedRestriction(T restriction){
        this.restrictions = Arrays.asList(restriction);
    }

    public List<T> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(List<T> restrictions) {
        this.restrictions = restrictions;
    }

    public String getLogicalCombiner() {
        return logicalCombiner;
    }

    public void setLogicalCombiner(String logicalCombiner) {
        this.logicalCombiner = logicalCombiner;
    }
}
