
package app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class, args); }
}

@RestController
class Api {
    @GetMapping("/") Map<String,Object> root() { return Map.of("name","Payments Lab (Adyen/Amazon Pay) API","ok",true); }
    @PostMapping("/api/payments/create") Map<String,Object> create() { return Map.of("ok",true,"clientSecret","test_"+System.currentTimeMillis()); }
    @PostMapping("/api/webhooks") Map<String,Object> wh(@RequestBody Map<String,Object> b) { return Map.of("ok",true); }
    @GetMapping("/api/methods") List<Map<String,Object>> methods() { return List.of(Map.of("id","adyen_card","label","Card"), Map.of("id","amazon_pay","label","Amazon Pay")); }
}
