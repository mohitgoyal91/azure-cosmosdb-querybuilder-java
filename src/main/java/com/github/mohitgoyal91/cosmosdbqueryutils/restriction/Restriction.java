package com.github.mohitgoyal91.cosmosdbqueryutils.restriction;

import com.github.mohitgoyal91.cosmosdbqueryutils.AddRestrictionInterface;
import com.github.mohitgoyal91.cosmosdbqueryutils.RestrictionInterface;
import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions.RestrictionExpression;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Restriction.
 *
 * @param <T> the type parameter
 */
public abstract class Restriction<T> implements RestrictionInterface, AddRestrictionInterface {

    /**
     * The Restriction expression list.
     */
    protected List<T> restrictionExpressionList = new ArrayList<>();
    private String logicalCombiner = Constants.Operators.Logical.AND;
    private Boolean isBuildCompleted;

    /**
     * Gets restriction expression list.
     *
     * @return the restriction expression list
     */
    public List<T> getRestrictionExpressionList() {
        return restrictionExpressionList;
    }

    /**
     * Sets restriction expression list.
     *
     * @param restrictionExpressionList the restriction expression list
     */
    public void setRestrictionExpressionList(List<T> restrictionExpressionList) {
        this.restrictionExpressionList = restrictionExpressionList;
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

    /**
     * Gets build completed.
     *
     * @return the build completed
     */
    public Boolean getBuildCompleted() {
        return isBuildCompleted;
    }

    /**
     * Sets build completed.
     *
     * @param buildCompleted the build completed
     */
    public void setBuildCompleted(Boolean buildCompleted) {
        isBuildCompleted = buildCompleted;
    }

    /**
     * Build restriction.
     *
     * @return the restriction
     */
    public Restriction build(){
        this.isBuildCompleted = true;
        return this;
    }

    /**
     * Filter restrictions.
     *
     * @param groupedRestrictions the grouped restrictions
     */
    public static void filterRestrictions(List<GroupedRestriction> groupedRestrictions) {
        List<GroupedRestriction> _groupedRestrictions = new ArrayList<>();
        List<GroupedRestriction> groupedRestrictionListestrictionList = groupedRestrictions;

        for (GroupedRestriction groupedRestriction : groupedRestrictionListestrictionList){
            List<Restriction> _restrictions = new ArrayList<>();
            List<Restriction> restrictionList = groupedRestriction.getRestrictions();
            for(Restriction restriction : restrictionList){
                if(Optional.ofNullable(restriction).isPresent()){
                    if(!(restriction).getRestrictionExpressionList().isEmpty()){
                        restriction.setLogicalCombiner(((RestrictionExpression) RestrictionHelper.getLastElementFromList(restriction.getRestrictionExpressionList())).getLogicalCombiner());
                        _restrictions.add(restriction);
                    }
                }
            }
            if(!_restrictions.isEmpty()){
               groupedRestriction.setRestrictions(_restrictions);
               _groupedRestrictions.add(groupedRestriction);
            }
        }

        groupedRestrictions.clear();
        groupedRestrictions.addAll(_groupedRestrictions);
    }

    /**
     * Append grouped restrictions.
     *
     * @param groupedRestrictions the grouped restrictions
     * @param queryBuilder        the query builder
     * @throws NoSuchMethodException     the no such method exception
     * @throws InvocationTargetException the invocation target exception
     * @throws IllegalAccessException    the illegal access exception
     */
    public static void appendGroupedRestrictions(List<GroupedRestriction> groupedRestrictions, StringBuilder queryBuilder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int i;
        for(i = 0; i < groupedRestrictions.size()-1; i++){
            appendRestrictions(groupedRestrictions.get(i).getRestrictions(), queryBuilder);
            queryBuilder.append(groupedRestrictions.get(i).getLogicalCombiner());
        }
        appendRestrictions(groupedRestrictions.get(i).getRestrictions(), queryBuilder);
    }

    /**
     * Append restrictions.
     *
     * @param <T>          the type parameter
     * @param restrictions the restrictions
     * @param queryBuilder the query builder
     * @throws NoSuchMethodException     the no such method exception
     * @throws IllegalAccessException    the illegal access exception
     * @throws InvocationTargetException the invocation target exception
     */
    public static <T> void appendRestrictions(List<T> restrictions, StringBuilder queryBuilder) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if(restrictions.size() > 1){
            queryBuilder.append(Constants.GENERAL.BRACKET_OPEN);
        }
        int j;
        for(j = 0; j < restrictions.size() - 1; j++){
            appendRestriction(restrictions.get(j), queryBuilder);
            queryBuilder.append(((Restriction)restrictions.get(j)).getLogicalCombiner());
        }
        appendRestriction(restrictions.get(j), queryBuilder);
        if(restrictions.size() > 1){
            queryBuilder.append(Constants.GENERAL.BRACKET_CLOSED);
        }
    }

    private static <T> void appendRestriction(T restriction, StringBuilder queryBuilder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        queryBuilder.append(Constants.GENERAL.BRACKET_OPEN);
        int i;
        for(i=0; i<((Restriction)restriction).getRestrictionExpressionList().size()-1; i++){
            T restrictionExpression = ((List<T>)((Restriction)restriction).getRestrictionExpressionList()).get(i);
            appendRestrictionExpression(restrictionExpression, queryBuilder);
            queryBuilder.append(((RestrictionExpression)restrictionExpression).getLogicalCombiner());
        }
        if(((Restriction)restriction).getRestrictionExpressionList().size() > 0){
            appendRestrictionExpression(((Restriction)restriction).getRestrictionExpressionList().get(i), queryBuilder);
        }
        queryBuilder.append(Constants.GENERAL.BRACKET_CLOSED);
    }

    private static <T> void appendRestrictionExpression(T restrictionExpression, StringBuilder queryBuilder) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RestrictionHelper.handleExpressionAppend(restrictionExpression, queryBuilder);
    }
}
