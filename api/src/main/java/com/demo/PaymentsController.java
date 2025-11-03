package com.demo;
import org.springframework.web.bind.annotation.*;
import java.util.*;
record Payment(String id, int amount, String currency, String status){}
@RestController @RequestMapping("/api/payments")
class PaymentsController {
  private final Map<String,Payment> db = new HashMap<>();
  @GetMapping("/") public Map<String,Object> root(){ return Map.of("name","Payments Lab API","ok",true); }
  @PostMapping public Payment create(@RequestBody Map<String,Object> in){
    String id="p"+System.currentTimeMillis();
    int amount=((Number)in.getOrDefault("amount",0)).intValue();
    String currency=String.valueOf(in.getOrDefault("currency","USD"));
    Payment p=new Payment(id,amount,currency,"created"); db.put(id,p); return p;
  }
  @GetMapping public Collection<Payment> list(){ return db.values(); }
  @PostMapping("/{id}/capture") public Payment capture(@PathVariable String id){
    Payment p=db.get(id); if(p==null) throw new RuntimeException("not_found");
    Payment c=new Payment(p.id(), p.amount(), p.currency(), "captured"); db.put(id,c); return c;
  }
}
