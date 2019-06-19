package com.shenzhen.teamway.assessctloffivesys.model;

import java.util.Objects;

/**
 * @program: acsproxy
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-05-30 16:07
 **/
public class HostInfo {
    private String Description;
    private String Location;
    private int index;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HostInfo hostInfo = (HostInfo) o;
        return index == hostInfo.index &&
                Objects.equals(Description, hostInfo.Description) &&
                Objects.equals(Location, hostInfo.Location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Description, Location, index);
    }

    @Override
    public String toString() {
        return "HostInfo{" +
                "Description='" + Description + '\'' +
                ", Location='" + Location + '\'' +
                ", index=" + index +
                '}';
    }
}