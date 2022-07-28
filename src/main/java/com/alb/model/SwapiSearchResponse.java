package com.alb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiSearchResponse<T> {

    private String count;
    private String next;
    private String previous;
    private List<T> results;

    @JsonProperty("results")
    public List<T> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }


}
