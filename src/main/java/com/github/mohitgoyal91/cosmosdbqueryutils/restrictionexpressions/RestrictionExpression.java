package com.github.mohitgoyal91.cosmosdbqueryutils.restrictionexpressions;

public class RestrictionExpression {

    private String propertyName;
    private Object value;
    private String operation;
    private String logicalCombiner;

    public RestrictionExpression() {
    }

    public RestrictionExpression(String propertyName, Object value, String operation, String logicalCombiner) {
        this.propertyName = propertyName;
        this.value = value;
        this.operation = operation;
        this.logicalCombiner = logicalCombiner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getLogicalCombiner() {
        return logicalCombiner;
    }

    public void setLogicalCombiner(String logicalCombiner) {
        this.logicalCombiner = logicalCombiner;
    }

    public <T> RestrictionExpression(T previousExpression, String nextLogicalCombiner){
        this.propertyName = ((RestrictionExpression)previousExpression).getPropertyName();
        this.value = ((RestrictionExpression)previousExpression).getValue();
        this.operation = ((RestrictionExpression)previousExpression).getOperation();
        this.logicalCombiner = nextLogicalCombiner;
    }
}
