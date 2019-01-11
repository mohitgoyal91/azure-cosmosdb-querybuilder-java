package com.github.psyduck.cosmosdbqueryutils.models;

public class Coordinate {
    private Double lat;
    private Double lng;

    public Coordinate(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString(){
        return "[" + this.lat + ", " + this.lng + "]";
    }
}
