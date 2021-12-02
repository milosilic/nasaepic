package com.nasa.epic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SunJ2000Position {
    @JsonProperty("x")
    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    double x;

    @JsonProperty("y")
    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    double y;

    @JsonProperty("z")
    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    double z;
}
