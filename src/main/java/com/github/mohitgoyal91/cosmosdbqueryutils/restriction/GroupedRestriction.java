package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * The type Grouped restriction.
 *
 * @param <T> the type parameter
 */
public class GroupedRestriction<T> {

    private List<T> restrictions;
    private String logicalCombiner = Constants.Operators.Logical.AND;

    /**
     * Instantiates a new Grouped restriction.
     *
     * @param restrictions the restrictions
     */
    public GroupedRestriction(T[] restrictions){
        this.restrictions = Arrays.asList(restrictions);
    }

    /**
     * Instantiates a new Grouped restriction.
     *
     * @param restriction the restriction
     */
    public GroupedRestriction(T restriction){
        this.restrictions = Arrays.asList(restriction);
    }

    /**
     * Gets restrictions.
     *
     * @return the restrictions
     */
    public List<T> getRestrictions() {
        return restrictions;
    }

    /**
     * Sets restrictions.
     *
     * @param restrictions the restrictions
     */
    public void setRestrictions(List<T> restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * Gets logical combiner.
     *
     * @return the logical combiner
     */
    public String getLogicalCombiner() {
        return logicalCombiner;
    }

    /**
     * Sets logical combiner.
     *
     * @param logicalCombiner the logical combiner
     */
    public void setLogicalCombiner(String logicalCombiner) {
        this.logicalCombiner = logicalCombiner;
    }
}
