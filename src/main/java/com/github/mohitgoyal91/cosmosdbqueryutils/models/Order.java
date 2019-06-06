package com.github.mohitgoyal91.cosmosdbqueryutils.models;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

/**
 * The type Order.
 */
public class Order {

    private String parameterName;
    private Constants.Order order;

    /**
     * Gets parameter name.
     *
     * @return the parameter name
     */
    public String getParameterName() {
        return parameterName;
    }

    /**
     * Sets parameter name.
     *
     * @param parameterName the parameter name
     */
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    /**
     * Gets order.
     *
     * @return the order
     */
    public Constants.Order getOrder() {
        return order;
    }

    /**
     * Sets order.
     *
     * @param order the order
     */
    public void setOrder(Constants.Order order) {
        this.order = order;
    }

    /**
     * Instantiates a new Order.
     *
     * @param parameterName the parameter name
     * @param order         the order
     */
    public Order(String parameterName, Constants.Order order) {
        this.parameterName = parameterName;
        this.order = order;
    }
}
