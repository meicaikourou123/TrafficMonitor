package com.example.model;


// define the data structure, including sensor_id, timestamp, speed

import java.time.Instant;

public class TrafficEvent {
    private String sensorId;
    private double speed;
    private Instant timestamp;
    private double latitude;
    private double longitude;
    private int vehicleCount;
    private int direction;
    public TrafficEvent() {
    }

    public TrafficEvent(String sensorId, double speed, Instant timestamp, double latitude, double longitude, int vehicleCount, int direction) {
        this.sensorId = sensorId;
        this.speed = speed;
        this.timestamp = timestamp;
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleCount = vehicleCount;
        this.direction = direction;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "TrafficEvent{" +
                "sensorId='" + sensorId + '\'' +
                ", speed=" + speed +
                ", timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", vehicleCount=" + vehicleCount +
                ", direction=" + direction +
                '}';
    }
}
