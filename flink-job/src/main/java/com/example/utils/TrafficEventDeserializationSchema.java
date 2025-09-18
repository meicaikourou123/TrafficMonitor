package com.example.utils;


import com.example.model.TrafficEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.flink.api.common.serialization.AbstractDeserializationSchema;

import java.io.IOException;

//kafka JSON deserialization logic
public class TrafficEventDeserializationSchema extends AbstractDeserializationSchema<TrafficEvent> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public TrafficEvent deserialize(byte[] message) throws IOException {
        return objectMapper.readValue(message, TrafficEvent.class);
    }
}