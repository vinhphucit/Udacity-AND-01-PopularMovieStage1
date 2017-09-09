package com.phuctran.popularmoviesfirststage.models;

import java.util.List;

/**
 * Created by phuctran on 9/9/17.
 */

public class MovieResponseWrapper {
    List<MovieModel> results;

    public MovieResponseWrapper(List<MovieModel> results) {
        this.results = results;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public void setResults(List<MovieModel> results) {
        this.results = results;
    }
}
