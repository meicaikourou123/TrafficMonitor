import json
import random
import time
import os
from datetime import datetime
from kafka import KafkaProducer

KAFKA_SERVER = os.getenv('KAFKA_SERVER', 'kafka:9092')
TOPIC = os.getenv('KAFKA_TOPIC', 'traffic-stream')

producer = KafkaProducer(
    bootstrap_servers=KAFKA_SERVER,
    value_serializer=lambda v: json.dumps(v).encode('utf-8')
)

def generate_traffic_data():
    return {
        "sensor_id": f"sensor_{random.randint(1, 20):03d}",
        "timestamp": datetime.utcnow().isoformat(),
        "latitude": round(random.uniform(45.4600, 45.4700), 6),
        "longitude": round(random.uniform(9.1800, 9.1900), 6),
        "avg_speed": round(random.uniform(10, 90), 2),
        "vehicle_count": random.randint(1, 5),
        "direction": random.choice([0, 90, 180, 270])
    }

if __name__ == "__main__":
    print(f"Sending traffic data to Kafka topic: {TOPIC} at {KAFKA_SERVER}")
    while True:
        data = generate_traffic_data()
        producer.send(TOPIC, value=data)
        print(f"Sent: {data}")
        time.sleep(1)