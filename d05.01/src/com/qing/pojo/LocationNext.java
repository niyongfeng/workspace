package com.qing.pojo;

import java.util.List;

/**
 * Created by niyongfeng on 2017/5/1.
 */
public class LocationNext {

    private Location location;
    private List<Daily> daily;
    private String last_update;

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

    @Override
    public String toString() {
        return "LocationNext{" +
                "location=" + location +
                ", daily=" + daily +
                ", last_update='" + last_update + '\'' +
                '}';
    }
}
