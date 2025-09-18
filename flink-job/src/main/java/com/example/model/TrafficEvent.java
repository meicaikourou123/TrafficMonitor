package com.example.model;


// define the data structure, including sensor_id, timestamp, speed

import java.time.Instant;

public class TrafficEvent {
    private String sensorId;
    private double speed;
    private Instant timestamp;
    public TrafficEvent() {
    }

    public TrafficEvent(String sensorId, double speed, Instant timestamp) {
        this.sensorId = sensorId;
        this.speed = speed;
        this.timestamp = timestamp;
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

    @Override
    public String toString() {
        return "TrafficEvent{" +
                "sensorId='" + sensorId + '\'' +
                ", speed=" + speed +
                ", timestamp=" + timestamp +
                '}';
    }
}
