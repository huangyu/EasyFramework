package com.huangyu.easyframework.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangyu on 2017-4-11.
 */
public class Result implements Serializable {

    Location location;
    List<Daily> daily = new ArrayList<>();
    String last_update;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Daily> getDaily() {
        return daily;
    }

    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

}
