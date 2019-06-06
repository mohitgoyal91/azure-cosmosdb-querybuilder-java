package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

/**
 * The type Restriction expression.
 */
public class RestrictionExpression {

    private String propertyName;
    private Object value;
    private String operation;
    private String logicalCombiner;

    /**
     * Instantiates a new Restriction expression.
     */
    public RestrictionExpression() {
    }

    /**
     * Instantiates a new Restriction expression.
     *
     * @param propertyName    the property name
     * @param value           the value
     * @param operation       the operation
     * @param logicalCombiner the logical combiner
     */
    public RestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner) {
        this.propertyName = propertyName;
        this.value = value;
        this.operation = operation;
        this.logicalCombiner = logicalCombiner;
    }

    /**
     * Gets property name.
     *
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets property name.
     *
     * @param propertyName the property name
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Gets operation.
     *
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets operation.
     *
     * @param operation the operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
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
     * Instantiates a new Restriction expression.
     *
     * @param previousExpression  the previous expression
     * @param nextLogicalCombiner the next logical combiner
     */
    public <T> RestrictionExpression(T previousExpression, String nextLogicalCombiner){
        this.propertyName = ((RestrictionExpression)previousExpression).getPropertyName();
        this.value = ((RestrictionExpression)previousExpression).getValue();
        this.operation = ((RestrictionExpression)previousExpression).getOperation();
        this.logicalCombiner = nextLogicalCombiner;
    }
}
