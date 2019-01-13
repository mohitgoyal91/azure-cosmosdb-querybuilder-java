package com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.FUNCTION.AGGREGATE.*;

public class AggregateFunction implements AggregateExtractor{

    private String propertyName;
    private String alias;
    private String aggregator;
    private String udf;

    public String getPropertyName() {
        return propertyName;
    }

    public String getAlias() {
        return alias;
    }

    public String getAggregator() {
        return aggregator;
    }

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
