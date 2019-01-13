package com.github.mohitgoyal91.cosmosdbqueryutils;

import com.github.mohitgoyal91.cosmosdbqueryutils.QueryProcessor.Processor;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Columns;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.GeoSpatialObject;
import com.github.mohitgoyal91.cosmosdbqueryutils.models.Order;
import com.github.mohitgoyal91.cosmosdbqueryutils.restriction.*;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;
import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.RestrictionHelper;

import java.util.ArrayList;
import java.util.List;

import static com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants.Operators.Logical.OR;

public class SelectQuery implements RestrictionExtractor{

    private boolean isCount;
    private Integer limit;
    private Columns columns = new Columns();
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
        GroupedRestriction groupedRestriction = new GroupedRestriction(restrictions);

        this.restrictions.add(groupedRestriction);
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
        return orderBy(Constants.GENERAL._TS, Constants.Order.DESC);
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
        return addRestrictions(new INRestriction().in(propertyName, values));
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
     * @param value
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery eq(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().eq(propertyName, value));
    }

    /**
     * To introduce a != restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery notEq(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().notEq(propertyName, value));
    }

    /**
     * To introduce a < restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lt(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().lt(propertyName, value));
    }

    /**
     * To introduce a <= restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lte(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().lte(propertyName, value));
    }

    /**
     * To introduce a > restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gt(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().gt(propertyName, value));
    }

    /**
     * To introduce a >= restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param value
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gte(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().gte(propertyName, value));
    }

    /**
     * To introduce an arithmetic restriction in the query with '='
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters & values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery eq(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().eq(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with '!='
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters & values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery notEq(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().notEq(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with '<'
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters & values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lt(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().lt(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with '<='
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters & values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lte(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().lte(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with '>'
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters & values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gt(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().gt(value, expression, parameters));
    }

    /**
     * To introduce an arithmetic restriction in the query with '>='
     * @param value distance in double
     * @param expression like {} + {}
     * @param parameters sequence of parameters & values
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gte(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().gte(value, expression, parameters));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a '='
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().eq(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a '!='
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().notEq(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a '<'
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().lt(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a '<='
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().lte(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a '>'
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().gt(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_DISTANCE restriction in the query with a '>='
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject
     * @param value distance value which should be compared
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().gte(propertyName, geoSpatialObject, value));
    }

    /**
     * To introduce a ST_WITHIN restriction in the query
     * @param propertyName property on which the restriction needs to be applied
     * @param geoSpatialObject
     * @return current instance of SelectQuery
     */
    @Override
    public SelectQuery within(String propertyName, GeoSpatialObject geoSpatialObject) {
        return addRestrictions(new GeoSpatialRestriction().within(propertyName, geoSpatialObject));
    }
}
