package com.huangyu.easyframework.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangyu on 2017-4-11.
 */
public class Weather implements Serializable {

    List<Result> results = new ArrayList<>();

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
