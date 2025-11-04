# Payments Lab

Language: Java (Spring Boot)

## How to run

API
```bash
cd payments-lab-native/api && ./gradlew bootRun
```

Web
```bash
cd payments-lab-native/web && python3 -m http.server 5505
```

Open http://localhost:5505

## Endpoints
- Ping: GET /\n- Charge: POST /api/pay
