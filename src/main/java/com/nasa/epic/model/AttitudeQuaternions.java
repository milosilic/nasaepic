package com.nasa.epic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AttitudeQuaternions {
    @JsonProperty("q0")
    public double getQ0() {
        return this.q0;
    }

    public void setQ0(double q0) {
        this.q0 = q0;
    }

    double q0;

    @JsonProperty("q1")
    public double getQ1() {
        return this.q1;
    }

    public void setQ1(double q1) {
        this.q1 = q1;
    }

    double q1;

    @JsonProperty("q2")
    public double getQ2() {
        return this.q2;
    }

    public void setQ2(double q2) {
        this.q2 = q2;
    }

    double q2;

    @JsonProperty("q3")
    public double getQ3() {
        return this.q3;
    }

    public void setQ3(double q3) {
        this.q3 = q3;
    }

    double q3;
}
