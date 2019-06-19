package com.shenzhen.teamway.assessctloffivesys.model;

import java.util.Objects;

/**
 * @program: acsproxy
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-05-30 16:06
 **/
public class GatewayInfo {

    private String Description;
    private String IP;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GatewayInfo that = (GatewayInfo) o;
        return Objects.equals(Description, that.Description) &&
                Objects.equals(IP, that.IP);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Description, IP);
    }

    @Override
    public String toString() {
        return "GatewayInfo{" +
                "Description='" + Description + '\'' +
                ", IP='" + IP + '\'' +
                '}';
    }
}