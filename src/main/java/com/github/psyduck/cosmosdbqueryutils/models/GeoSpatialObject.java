package com.github.psyduck.cosmosdbqueryutils.models;

import com.github.psyduck.cosmosdbqueryutils.utilities.Constants;

import java.util.Arrays;
import java.util.List;

public class GeoSpatialObject {

    private String functionName;
    private Constants.GeoSpatialTypes type;
    private List<Coordinate> coordinates;
    private Double value;

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Constants.GeoSpatialTypes getType() {
        return type;
    }

    public void setType(Constants.GeoSpatialTypes type) {
        this.type = type;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public GeoSpatialObject(Constants.GeoSpatialTypes type, Coordinate... coordinates){
        this.type = type;
        this.coordinates = Arrays.asList((Coordinate[])coordinates);
    }

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
