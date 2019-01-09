package com.psyduck.cosmosdbqueryutils.models;

import com.psyduck.cosmosdbqueryutils.utilities.Constants;

public class Order {

    private String parameterName;
    private Constants.Order order;

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Constants.Order getOrder() {
        return order;
    }

    public void setOrder(Constants.Order order) {
        this.order = order;
    }

    public Order(String parameterName, Constants.Order order) {
        this.parameterName = parameterName;
        this.order = order;
    }
}
