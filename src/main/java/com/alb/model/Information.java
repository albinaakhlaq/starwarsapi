package com.alb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Information {
    private StarShip starShip;
    private int crew;
    private boolean isLeiaOnPlanet;


    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    @JsonProperty("isLeiaOnPlanet")
    public boolean isLeiaOnPlanet() {
        return isLeiaOnPlanet;
    }

    @JsonProperty("isLeiaOnPlanet")
    public void setLeiaOnPlanet(boolean leiaOnPlanet) {
        isLeiaOnPlanet = leiaOnPlanet;
    }

    public StarShip getStarShip() {
        return starShip;
    }

    public void setStarShip(StarShip starShip) {
        this.starShip = starShip;
    }


}
