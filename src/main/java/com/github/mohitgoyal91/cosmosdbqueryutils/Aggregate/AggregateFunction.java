package com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.FUNCTION.AGGREGATE.*;

/**
 * The type Aggregate function.
 */
public class AggregateFunction implements AggregateExtractor{

    private String propertyName;
    private String alias;
    private String aggregator;
    private String udf;

    /**
     * Gets property name.
     *
     * @return the property name
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Gets alias.
     *
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Gets aggregator.
     *
     * @return the aggregator
     */
    public String getAggregator() {
        return aggregator;
    }

    /**
     * Gets udf.
     *
     * @return the udf
     */
    public String getUdf() {
        return udf;
    }

    private void setPropertyAlias(String propertyName, String alias, String udf) {
        this.propertyName = propertyName;
        this.alias = alias;
        this.udf = udf;
    }

    @Override
    public AggregateFunction count(String propertyName, String alias) {
        setPropertyAlias(propertyName, alias, null);
        this.aggregator = COUNT;
        return this;
    }

    @Override
    public AggregateFunction min(String propertyName, String alias, String udf) {
        setPropertyAlias(propertyName, alias, udf);
        this.aggregator = MIN;
        return this;
    }

    @Override
    public AggregateFunction max(String propertyName, String alias, String udf) {
        setPropertyAlias(propertyName, alias, udf);
        this.aggregator = MAX;
        return this;
    }

    @Override
    public AggregateFunction sum(String propertyName, String alias, String udf) {
        setPropertyAlias(propertyName, alias, udf);
        this.aggregator = SUM;
        return this;
    }

    @Override
    public AggregateFunction avg(String propertyName, String alias, String udf) {
        setPropertyAlias(propertyName, alias, udf);
        this.aggregator = AVG;
        return this;
    }
}
