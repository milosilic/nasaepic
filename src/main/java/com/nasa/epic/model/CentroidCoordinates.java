package com.nasa.epic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CentroidCoordinates {
    @JsonProperty("lat")
    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    double lat;

    @JsonProperty("lon")
    public double getLon() {
        return this.lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    double lon;
}
