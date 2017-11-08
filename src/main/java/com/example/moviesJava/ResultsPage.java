package com.example.moviesJava;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsPage {
    private List<Movie> results;

    public ResultsPage() {
    }

    public List<Movie> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "ResultsPage{" +
                "results=" + results +
                '}';
    }
}
