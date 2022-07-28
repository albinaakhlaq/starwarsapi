package com.alb.model;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name","class","model"})
public class StarShip {

    private String name;
    private String StarshipClass;
    private String model;
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


    @JsonProperty("class")
    public String getStarshipClass() {
        return StarshipClass;
    }

    @JsonProperty("starship_class")
    public void setStarshipClass(String starshipClass) {
        StarshipClass = starshipClass;
    }

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
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
