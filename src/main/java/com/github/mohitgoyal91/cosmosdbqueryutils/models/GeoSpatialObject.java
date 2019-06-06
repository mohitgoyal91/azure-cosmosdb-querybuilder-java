package com.github.mohitgoyal91.cosmosdbqueryutils.models;

import com.github.mohitgoyal91.cosmosdbqueryutils.utilities.Constants;

import java.util.Arrays;
import java.util.List;

/**
 * The type Geo spatial object.
 */
public class GeoSpatialObject {

    private String functionName;
    private Constants.GeoSpatialTypes type;
    private List<Coordinate> coordinates;
    private Double value;

    /**
     * Gets function name.
     *
     * @return the function name
     */
    public String getFunctionName() {
        return functionName;
    }

    /**
     * Sets function name.
     *
     * @param functionName the function name
     */
    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Constants.GeoSpatialTypes getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Constants.GeoSpatialTypes type) {
        this.type = type;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public Double getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(Double value) {
        this.value = value;
    }

    /**
     * Instantiates a new Geo spatial object.
     *
     * @param type        the type
     * @param coordinates the coordinates
     */
    public GeoSpatialObject(Constants.GeoSpatialTypes type, Coordinate... coordinates){
        this.type = type;
        this.coordinates = Arrays.asList((Coordinate[])coordinates);
    }

    /**
     * Instantiates a new Geo spatial object.
     *
     * @param type        the type
     * @param coordinates the coordinates
     */
    public GeoSpatialObject(Constants.GeoSpatialTypes type, List<Coordinate> coordinates){
        this.type = type;
        this.coordinates = coordinates;
    }

    @Override
    public String toString(){
        return "{\"type\":\"" + this.type.getName()
                + "\", \"coordinates\":" + this.coordinates
                + "}";
    }
}
