package com.shenzhen.teamway.assessctloffivesys.model;

import java.util.Date;
import java.util.Objects;

/**
 * @program: acsproxy
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-05-30 16:06
 **/
public class Payload {
    private String FaceImage;
    private String VehicleNoImage;
    private String VehicleImage;
    private String CardId;
    private String DoorStatus;
    private int EventCode;
    private Date TimeStamp;

    public String getFaceImage() {
        return FaceImage;
    }

    public void setFaceImage(String faceImage) {
        FaceImage = faceImage;
    }

    public String getVehicleNoImage() {
        return VehicleNoImage;
    }

    public void setVehicleNoImage(String vehicleNoImage) {
        VehicleNoImage = vehicleNoImage;
    }

    public String getVehicleImage() {
        return VehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        VehicleImage = vehicleImage;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        CardId = cardId;
    }

    public String getDoorStatus() {
        return DoorStatus;
    }

    public void setDoorStatus(String doorStatus) {
        DoorStatus = doorStatus;
    }

    public int getEventCode() {
        return EventCode;
    }

    public void setEventCode(int eventCode) {
        EventCode = eventCode;
    }

    public Date getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        TimeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payload payload = (Payload) o;
        return EventCode == payload.EventCode &&
                Objects.equals(FaceImage, payload.FaceImage) &&
                Objects.equals(VehicleNoImage, payload.VehicleNoImage) &&
                Objects.equals(VehicleImage, payload.VehicleImage) &&
                Objects.equals(CardId, payload.CardId) &&
                Objects.equals(DoorStatus, payload.DoorStatus) &&
                Objects.equals(TimeStamp, payload.TimeStamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(FaceImage, VehicleNoImage, VehicleImage, CardId, DoorStatus, EventCode, TimeStamp);
    }

    @Override
    public String toString() {
        return "Payload{" +
                "FaceImage='" + FaceImage + '\'' +
                ", VehicleNoImage='" + VehicleNoImage + '\'' +
                ", VehicleImage='" + VehicleImage + '\'' +
                ", CardId='" + CardId + '\'' +
                ", DoorStatus='" + DoorStatus + '\'' +
                ", EventCode=" + EventCode +
                ", TimeStamp=" + TimeStamp +
                '}';
    }
}