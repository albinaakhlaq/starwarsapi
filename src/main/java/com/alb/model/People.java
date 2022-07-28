package com.alb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class People {
    private String name;
    private List<String> starshipUrl;
    private String url;
    private String homeworld;


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("starships")
    public List<String> getStarshipUrl() {
        return starshipUrl;
    }

    @JsonProperty("starships")
    public void setStarshipUrl(List<String> starshipUrl) {
        this.starshipUrl = starshipUrl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("homeworld")
    public String getHomeworld() {
        return homeworld;
    }

    @JsonProperty("homeworld")
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }



    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", starships=" + starshipUrl +
                '}';
    }




}