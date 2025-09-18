package com.example.aggregator;


import com.example.model.TrafficEvent;
import org.apache.flink.api.common.functions.AggregateFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;

//customized aggregation function
public class AverageSpeedAndCountAggregator implements AggregateFunction<
        TrafficEvent,
        Tuple2<Double, Long>,    // 累加器：总速度，总数量
        Tuple3<String, Double, Long> // 输出：sensor_id, 平均速度, 数量
        > {


    @Override
    public Tuple2<Double, Long> createAccumulator() {
        return Tuple2.of(0.0, 0L);
    }

    @Override
    public Tuple2<Double, Long> add(TrafficEvent value, Tuple2<Double, Long> acc) {
        return Tuple2.of(acc.f0 + value.speed, acc.f1 + 1);
    }

    @Override
    public Tuple3<String, Double, Long> getResult(Tuple2<Double, Long> acc) {
        double avgSpeed = acc.f1 == 0 ? 0 : acc.f0 / acc.f1;
        return Tuple3.of("UNKNOWN", avgSpeed, acc.f1); // sensor_id 可用窗口函数包装器补上
    }

    @Override
    public Tuple2<Double, Long> merge(Tuple2<Double, Long> a, Tuple2<Double, Long> b) {
        return Tuple2.of(a.f0 + b.f0, a.f1 + b.f1);
    }
}