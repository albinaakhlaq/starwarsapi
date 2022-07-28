package com.alb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StarShip {

    private String name;
    private String model;
    private String StarshipClass;
    private String crew;

    @JsonProperty("crew")
    @JsonIgnore
    public String getCrew() {
        return crew;
    }

    @JsonProperty("crew")

    public void setCrew(String crew) {
        this.crew = crew;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("class")
    public String getStarshipClass() {
        return StarshipClass;
    }

    @JsonProperty("starship_class")
    public void setStarshipClass(String starshipClass) {
        StarshipClass = starshipClass;
    }

    @Override
    public String toString() {
        return "StarShip{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", StarshipClass='" + StarshipClass + '\'' +
                '}';
    }
}
