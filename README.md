# Payments Lab

**Stack:** Java (Spring Boot)  
**API:** http://127.0.0.1:5105  
**Web:** http://localhost:5505

## Run (local)

### API
cd payments-lab-native/api && ./gradlew bootRun   # first time: gradle wrapper etc.

### Web (static tester)
cd payments-lab-native/web && python3 -m http.server 5505

## Test
- **Ping:** curl -s http://127.0.0.1:5105 | jq .
- **Ping:** GET /\n- **Charge (demo):** POST /api/pay

