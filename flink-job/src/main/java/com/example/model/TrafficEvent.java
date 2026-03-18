package com.example.model;


// define the data structure, including sensor_id, timestamp, speed

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.flink.api.java.io.CsvOutputFormat;

public class TrafficEvent {
    @JsonProperty("sensor_id")
    private String sensorId;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("avg_speed")
    private double speed;  // unit km/h

    @JsonProperty("vehicle_count")
    private int vehicleCount;

    @JsonProperty("direction")
    private int direction;

    // 加上 eventTimeMs 字段（不参与反序列化也没问题）
    private long eventTimeMs;
    public TrafficEvent() {
    }

    public TrafficEvent(String sensorId, double speed, String timestamp, double latitude, double longitude, int vehicleCount, int direction) {
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String  timestamp) {
        this.timestamp = timestamp;
    }

    public Long getEventTimeMs() { return eventTimeMs; }
    public void setEventTimeMs(Long eventTimeMs) { this.eventTimeMs = eventTimeMs; }


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
