package com.github.mohitgoyal91.cosmosdbqueryutils.models;

/**
 * The type Coordinate.
 */
public class Coordinate {
    private Double lat;
    private Double lng;

    /**
     * Instantiates a new Coordinate.
     *
     * @param lat the lat
     * @param lng the lng
     */
    public Coordinate(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString(){
        return "[" + this.lat + ", " + this.lng + "]";
    }
}
