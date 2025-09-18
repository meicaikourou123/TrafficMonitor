FROM python:3.10-slim

WORKDIR /app

COPY simulator.py .
COPY requirements.txt .

RUN pip install --no-cache-dir -r requirements.txt

CMD ["python", "simulator.py"]