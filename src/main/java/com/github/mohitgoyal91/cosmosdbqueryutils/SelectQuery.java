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

    public String createQuery(){
        Processor processor = new Processor(this);
        return processor.processQuery();
    }

    public SelectQuery addColumns(Columns columns){
        this.columns = columns;
        return this;
    }

    public SelectQuery limitResults(int limit){
        this.limit = limit;
        return this;
    }

    public SelectQuery addRestrictions(Restriction... restriction){
        GroupedRestriction groupedRestriction = new GroupedRestriction(restriction);

        this.restrictions.add(groupedRestriction);
        return this;
    }

    public SelectQuery or(){
        if(this.restrictions.size() > 0){
            RestrictionHelper.getLastElementFromList(this.restrictions).setLogicalCombiner(OR);
        }
        return this;
    }

    public SelectQuery orAddRestrictions(Restriction... restrictions){
        if(this.restrictions.size() > 0){
            RestrictionHelper.getLastElementFromList(this.restrictions).setLogicalCombiner(OR);
        }
        this.addRestrictions(restrictions);
        return this;
    }

    public SelectQuery andAddRestrictions(Restriction... restrictions){
        this.addRestrictions(restrictions);
        return this;
    }

    public SelectQuery orderByTS(Constants.Order order){
        return addOrdering(Constants.GENERAL._TS, Constants.Order.DESC);
    }

    public SelectQuery addOrdering(String parameterName, Constants.Order order) {
       this.order = new Order(parameterName, order);
       return this;
    }

    public SelectQuery count() {
        this.isCount = true;
        return this;
    }

    @Override
    public SelectQuery id(String id) {
        return eq(Constants.GENERAL.ID, id);
    }

    @Override
    public SelectQuery in(String propertyName, Object... values) {
        return addRestrictions(new INRestriction().in(propertyName, values));
    }

    public SelectQuery in(String propertyName, List<Object> values) {
        return addRestrictions(new INRestriction().in(propertyName, values));
    }

    @Override
    public SelectQuery eq(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().eq(propertyName, value));
    }

    @Override
    public SelectQuery notEq(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().notEq(propertyName, value));
    }

    @Override
    public SelectQuery lt(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().lt(propertyName, value));
    }

    @Override
    public SelectQuery lte(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().lte(propertyName, value));
    }

    @Override
    public SelectQuery gt(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().gt(propertyName, value));
    }

    @Override
    public SelectQuery gte(String propertyName, Object value) {
        return addRestrictions(new ComparisonRestriction().gte(propertyName, value));
    }

    @Override
    public SelectQuery eq(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().eq(value, expression, parameters));
    }

    @Override
    public SelectQuery notEq(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().notEq(value, expression, parameters));
    }

    @Override
    public SelectQuery lt(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().lt(value, expression, parameters));
    }

    @Override
    public SelectQuery lte(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().lte(value, expression, parameters));
    }

    @Override
    public SelectQuery gt(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().gt(value, expression, parameters));
    }

    @Override
    public SelectQuery gte(Double value, String expression, Object... parameters) {
        return addRestrictions(new ArithmeticRestriction().gte(value, expression, parameters));
    }

    @Override
    public SelectQuery eq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().eq(propertyName, geoSpatialObject, value));
    }

    @Override
    public SelectQuery notEq(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().notEq(propertyName, geoSpatialObject, value));
    }

    @Override
    public SelectQuery lt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().lt(propertyName, geoSpatialObject, value));
    }

    @Override
    public SelectQuery lte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().lte(propertyName, geoSpatialObject, value));
    }

    @Override
    public SelectQuery gt(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().gt(propertyName, geoSpatialObject, value));
    }

    @Override
    public SelectQuery gte(String propertyName, GeoSpatialObject geoSpatialObject, Double value) {
        return addRestrictions(new GeoSpatialRestriction().gte(propertyName, geoSpatialObject, value));
    }

    @Override
    public SelectQuery within(String propertyName, GeoSpatialObject geoSpatialObject) {
        return addRestrictions(new GeoSpatialRestriction().within(propertyName, geoSpatialObject));
    }
}
