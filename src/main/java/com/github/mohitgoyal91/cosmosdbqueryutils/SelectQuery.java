package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate.AggregateExtractorMin;
import com.github.mohitgoyal91.cosmosdbqueryutils.Aggregate.AggregateFunction;
import com.github.mohitgoyal91.cosmosdbqueryutils.QueryProcessor.Processor;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Columns;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Order;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.*;
import com.github.mohitgoyal91.cosmosdbqueryutils.restrictionextractors.*;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Logical.OR;

public class SelectQuery extends RestrictionExtractor implements AggregateExtractorMin {

    private boolean isCount;
    private Integer limit;
    private Columns columns = new Columns();
    private List<AggregateFunction> aggregateFunctions = new ArrayList<>();
    private List<GroupedRestriction> restrictions = new ArrayList();
    private Order order;

    /**
     * Creates a new Instance of a SelectQuery
     */
    public SelectQuery(){
    }

    public boolean isCount() {
        return isCount;
    }

    public Integer getLimit() {
        return limit;
    }

    public Columns getColumns() {
        return columns;
    }

    public List<GroupedRestriction> getRestrictions() {
        return restrictions;
    }

    public Order getOrder() {
        return order;
    }

    public List<AggregateFunction> getAggregateFunctions() {
        return aggregateFunctions;
    }

    /**
     * To build the query
     * @return Query
     */
    public String createQuery(){
        Processor processor = new Processor(this);
        return processor.processQuery();
    }

    /**
     * To add columns
     * @param columns Object
     * @return current instance of SelectQuery
     */
    public SelectQuery columns(Columns columns){
        this.columns = columns;
        return this;
    }

    /**
     * To add limit
     * @param limit total number of results to be fetched
     * @return current instance of SelectQuery
     */
    public SelectQuery limitResults(int limit){
        this.limit = limit;
        return this;
    }

    /**
     * To add reestrictions
     * @param restrictions Multiple restrictions to be passed separated by comma ","
     * @return current instance of SelectQuery
     */
    public SelectQuery addRestrictions(Restriction... restrictions){
        if(Optional.ofNullable(restrictions).isPresent()){
            List<Restriction> _restrictions = new ArrayList<>();
            for(Restriction restriction : restrictions){
                if(Optional.ofNullable(restriction).isPresent()){
                    _restrictions.add(restriction);
                }
            }
            GroupedRestriction groupedRestriction = new GroupedRestriction(_restrictions.toArray());

            this.restrictions.add(groupedRestriction);
        }
        return this;
    }

    /**
     * to separate the previous and next restrictions by an 'OR'
     * @return current instance of SelectQuery
     */
    public SelectQuery or(){
        if(this.restrictions.size() > 0){
            RestrictionHelper.getLastElementFromList(this.restrictions).setLogicalCombiner(OR);
        }
        return this;
    }

    /**
     * To add restrictions, with a separation of 'OR' between previous and this restriction
     * @param restrictions Multiple restrictions to be passed separated by comma ","
     * @return current instance of SelectQuery
     */
    public SelectQuery orAddRestrictions(Restriction... restrictions){
        if(this.restrictions.size() > 0){
            RestrictionHelper.getLastElementFromList(this.restrictions).setLogicalCombiner(OR);
        }
        this.addRestrictions(restrictions);
        return this;
    }

    /**
     * To add restrictions, with a separation of 'AND' between previous and this restriction
     * @param restrictions Multiple restrictions to be passed separated by comma ","
     * @return current instance of SelectQuery
     */
    public SelectQuery andAddRestrictions(Restriction... restrictions){
        this.addRestrictions(restrictions);
        return this;
    }

    /**
     * Ordering the query by _ts
     * @param order Enum DESC or ASC
     * @return current instance of SelectQuery
     */
    public SelectQuery orderByTS(Constants.Order order){
        return orderBy(Constants.GENERAL._TS, order);
    }

    /**
     * Ordering the query by parameter
     * @param parameterName parameter by which the query is to be ordered
     * @param order Enum DESC or ASC
     * @return current instance of SelectQuery
     */
    public SelectQuery orderBy(String parameterName, Constants.Order order) {
       this.order = new Order(parameterName, order);
       return this;
    }

    /**
     * To specify if only the count of rows is required
     * @return current instance of SelectQuery
     */
    public SelectQuery count() {
        this.isCount = true;
        return this;
    }

    /**
     * To create query with id restriction
     * @param id id of the document to be fetched
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery id(String id) {
        return eq(Constants.GENERAL.ID, id);
    }

    /**
     * To introduce an in restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param values values separated by comma ','
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery in(String propertyName, Object... values) {
        return addRestrictions(new RestrictionBuilder().in(propertyName, values));
    }

    /**
     * To introduce an in restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param values list of values
     * @return current instance of SelectQuery
     */
    public SelectQuery in(String propertyName, List<Object> values) {
        return addRestrictions(new INRestriction().in(propertyName, values));
    }

    /**
     * To introduce a = restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery eq(String propertyName, Object value) {
        return addRestrictions(new RestrictionBuilder().eq(propertyName, value));
    }

    /**
     * To introduce a {@literal =} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery notEq(String propertyName, Object value) {
        return addRestrictions(new RestrictionBuilder().notEq(propertyName, value));
    }

    /**
     * To introduce a {@literal <} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lt(String propertyName, Object value) {
        return addRestrictions(new RestrictionBuilder().lt(propertyName, value));
    }

    /**
     * To introduce a {@literal <=} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lte(String propertyName, Object value) {
        return addRestrictions(new RestrictionBuilder().lte(propertyName, value));
    }

    /**
     * To introduce a {@literal >} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gt(String propertyName, Object value) {
        return addRestrictions(new RestrictionBuilder().gt(propertyName, value));
    }

    /**
     * To introduce a {@literal >=} restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value value which needs to be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gte(String propertyName, Object value) {
        return addRestrictions(new RestrictionBuilder().gte(propertyName, value));
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal =}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery eq(Double value, String expression, Object... parameters) {
        return addRestrictions(new RestrictionBuilder().eq(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal !=}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery notEq(Double value, String expression, Object... parameters) {
        return addRestrictions(new RestrictionBuilder().notEq(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal <}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lt(Double value, String expression, Object... parameters) {
        return addRestrictions(new RestrictionBuilder().lt(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal <=}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lte(Double value, String expression, Object... parameters) {
        return addRestrictions(new RestrictionBuilder().lte(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal >}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gt(Double value, String expression, Object... parameters) {
        return addRestrictions(new RestrictionBuilder().gt(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with {@literal >=}
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters and values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gte(Double value, String expression, Object... parameters) {
        return addRestrictions(new RestrictionBuilder().gte(value, expression, parameters));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal =}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new RestrictionBuilder().eq(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal !=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new RestrictionBuilder().notEq(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal <}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new RestrictionBuilder().lt(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal <=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new RestrictionBuilder().lte(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal >}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new RestrictionBuilder().gt(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a {@literal >=}
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new RestrictionBuilder().gte(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_WITHIN restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject GeoSpatialObject
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery within(String propertyName, GeoSpatialObject geoSpatialObject) {
        return addRestrictions(new RestrictionBuilder().within(propertyName, geoSpatialObject));
    }

    @Override
    public SelectQuery count(String propertyName) {
        return count(propertyName, propertyName);
    }

    @Override
    public SelectQuery count(String propertyName, String alias) {
        aggregateFunctions.add(new AggregateFunction().count(propertyName, alias));
        return this;
    }

    @Override
    public SelectQuery min(String propertyName) {
        return min(propertyName, propertyName, null);
    }

    @Override
    public SelectQuery min(String propertyName, String alias) {
        return min(propertyName, alias, null);
    }

    @Override
    public SelectQuery min(String propertyName, String alias, String udf) {
        aggregateFunctions.add(new AggregateFunction().min(propertyName, alias, udf));
        return this;
    }

    @Override
    public SelectQuery max(String propertyName) {
        return max(propertyName, propertyName, null);
    }


    @Override
    public SelectQuery max(String propertyName, String alias) {
        return max(propertyName, alias, null);
    }

    @Override
    public SelectQuery max(String propertyName, String alias, String udf) {
        aggregateFunctions.add(new AggregateFunction().max(propertyName, alias, udf));
        return this;
    }

    @Override
    public SelectQuery sum(String propertyName) {
        return sum(propertyName, propertyName, null);
    }


    @Override
    public SelectQuery sum(String propertyName, String alias) {
        return sum(propertyName, alias, null);
    }

    @Override
    public SelectQuery sum(String propertyName, String alias, String udf) {
        aggregateFunctions.add(new AggregateFunction().sum(propertyName, alias, udf));
        return this;
    }

    @Override
    public SelectQuery avg(String propertyName) {
        return avg(propertyName, propertyName, null);
    }


    @Override
    public SelectQuery avg(String propertyName, String alias) {
        return avg(propertyName, alias, null);
    }

    @Override
    public SelectQuery avg(String propertyName, String alias, String udf) {
        aggregateFunctions.add(new AggregateFunction().avg(propertyName, alias, udf));
        return this;
    }

    @Override
    public SelectQuery arrayContains(String propertyName, Object value) {
        return addRestrictions(new RestrictionBuilder().arrayContains(propertyName, value));
    }

    @Override
    public SelectQuery isDefined(String propertyName) {
        return addRestrictions(new RestrictionBuilder().isDefined(propertyName));
    }

    @Override
    public SelectQuery isNotDefined(String propertyName) {
        return addRestrictions(new RestrictionBuilder().isNotDefined(propertyName));
    }
}
