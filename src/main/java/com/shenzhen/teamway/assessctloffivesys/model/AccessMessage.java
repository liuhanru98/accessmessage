package com.shenzhen.teamway.assessctloffivesys.model;

import java.util.Objects;

/**
 * @program: acsproxy
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-05-30 16:08
 **/
public class AccessMessage {

    private String Version="1.0";
    private String DeviceType;
    private String DataType;
    private String Vendor;
    private Payload Payload;
    private GatewayInfo GatewayInfo;
    private HostInfo HostInfo;
    private ChannelInfo ChannelInfo;

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String deviceType) {
        DeviceType = deviceType;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public com.shenzhen.teamway.assessctloffivesys.model.Payload getPayload() {
        return Payload;
    }

    public void setPayload(com.shenzhen.teamway.assessctloffivesys.model.Payload payload) {
        Payload = payload;
    }

    public com.shenzhen.teamway.assessctloffivesys.model.GatewayInfo getGatewayInfo() {
        return GatewayInfo;
    }

    public void setGatewayInfo(com.shenzhen.teamway.assessctloffivesys.model.GatewayInfo gatewayInfo) {
        GatewayInfo = gatewayInfo;
    }

    public com.shenzhen.teamway.assessctloffivesys.model.HostInfo getHostInfo() {
        return HostInfo;
    }

    public void setHostInfo(com.shenzhen.teamway.assessctloffivesys.model.HostInfo hostInfo) {
        HostInfo = hostInfo;
    }

    public com.shenzhen.teamway.assessctloffivesys.model.ChannelInfo getChannelInfo() {
        return ChannelInfo;
    }

    public void setChannelInfo(com.shenzhen.teamway.assessctloffivesys.model.ChannelInfo channelInfo) {
        ChannelInfo = channelInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessMessage that = (AccessMessage) o;
        return Objects.equals(Version, that.Version) &&
                Objects.equals(DeviceType, that.DeviceType) &&
                Objects.equals(DataType, that.DataType) &&
                Objects.equals(Vendor, that.Vendor) &&
                Objects.equals(Payload, that.Payload) &&
                Objects.equals(GatewayInfo, that.GatewayInfo) &&
                Objects.equals(HostInfo, that.HostInfo) &&
                Objects.equals(ChannelInfo, that.ChannelInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Version, DeviceType, DataType, Vendor, Payload, GatewayInfo, HostInfo, ChannelInfo);
    }

    @Override
    public String toString() {
        return "AccessMessage{" +
                "Version='" + Version + '\'' +
                ", DeviceType='" + DeviceType + '\'' +
                ", DataType='" + DataType + '\'' +
                ", Vendor='" + Vendor + '\'' +
                ", Payload=" + Payload +
                ", GatewayInfo=" + GatewayInfo +
                ", HostInfo=" + HostInfo +
                ", ChannelInfo=" + ChannelInfo +
                '}';
    }
}