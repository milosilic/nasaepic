package com.nasa.epic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Epic {
    @JsonProperty("identifier")
    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    String identifier;

    @JsonProperty("caption")
    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    String caption;

    @JsonProperty("image")
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    String image;

    @JsonProperty("version")
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    String version;

    @JsonProperty("centroid_coordinates")
    public CentroidCoordinates getCentroid_coordinates() {
        return this.centroid_coordinates;
    }

    public void setCentroid_coordinates(CentroidCoordinates centroid_coordinates) {
        this.centroid_coordinates = centroid_coordinates;
    }

    CentroidCoordinates centroid_coordinates;

    @JsonProperty("dscovr_j2000_position")
    public DscovrJ2000Position getDscovr_j2000_position() {
        return this.dscovr_j2000_position;
    }

    public void setDscovr_j2000_position(DscovrJ2000Position dscovr_j2000_position) {
        this.dscovr_j2000_position = dscovr_j2000_position;
    }

    DscovrJ2000Position dscovr_j2000_position;

    @JsonProperty("lunar_j2000_position")
    public LunarJ2000Position getLunar_j2000_position() {
        return this.lunar_j2000_position;
    }

    public void setLunar_j2000_position(LunarJ2000Position lunar_j2000_position) {
        this.lunar_j2000_position = lunar_j2000_position;
    }

    LunarJ2000Position lunar_j2000_position;

    @JsonProperty("sun_j2000_position")
    public SunJ2000Position getSun_j2000_position() {
        return this.sun_j2000_position;
    }

    public void setSun_j2000_position(SunJ2000Position sun_j2000_position) {
        this.sun_j2000_position = sun_j2000_position;
    }

    SunJ2000Position sun_j2000_position;

    @JsonProperty("attitude_quaternions")
    public AttitudeQuaternions getAttitude_quaternions() {
        return this.attitude_quaternions;
    }

    public void setAttitude_quaternions(AttitudeQuaternions attitude_quaternions) {
        this.attitude_quaternions = attitude_quaternions;
    }

    AttitudeQuaternions attitude_quaternions;

    @JsonProperty("date")
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    @JsonProperty("coords")
    public Coords getCoords() {
        return this.coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    Coords coords;
}
