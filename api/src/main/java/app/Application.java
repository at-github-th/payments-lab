package app;
import org.springframework.boot.SpringApplication; import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*; import org.springframework.context.annotation.Bean; import org.springframework.web.servlet.config.annotation.*;
import java.util.*;
@SpringBootApplication public class Application {
  public static void main(String[] args){ SpringApplication.run(Application.class,args); }
  @Bean public WebMvcConfigurer cors(){ return new WebMvcConfigurer(){ @Override public void addCorsMappings(CorsRegistry r){ r.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*"); } }; }
}
@RestController class Api {
  @GetMapping("/") Map<String,Object> root(){ return Map.of("name","Payments Lab API","ok",true); }
  @GetMapping("/api/methods") List<Map<String,Object>> methods(){ return List.of(Map.of("id","adyen_card","label","Card"), Map.of("id","amazon_pay","label","Amazon Pay")); }
}
