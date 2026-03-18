package com.example.utils;

// TrafficEventTimeConverter 类 (MapFunction) 负责解析并设置 eventTimeMs 字段
import com.example.model.TrafficEvent;
import org.apache.flink.api.common.functions.MapFunction;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;

public class TrafficEventTimeConverter implements MapFunction<TrafficEvent, TrafficEvent> {

    // 匹配您提供的格式: yyyy-MM-dd'T'HH:mm:ss.SSSSSS (微秒级)
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

    @Override
    public TrafficEvent map(TrafficEvent event) throws Exception {
        String timestampStr = event.getTimestamp();

        try {
            // 假设时间是 UTC 时间
            long epochMilli = LocalDateTime.parse(timestampStr, FORMATTER)
                    .toInstant(ZoneOffset.UTC)
                    .toEpochMilli();

            event.setEventTimeMs(epochMilli);
            return event;

        } catch (Exception e) {
            // 容错处理：记录错误或返回一个带默认时间戳（如当前处理时间）的事件
            System.err.println("Error parsing timestamp: " + timestampStr + " - " + e.getMessage());
            // 通常在生产环境会抛出异常或使用 Side Output 隔离脏数据
            throw e;
        }
    }
}