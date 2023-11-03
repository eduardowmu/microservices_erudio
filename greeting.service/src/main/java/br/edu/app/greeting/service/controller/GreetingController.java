package br.edu.app.greeting.service.controller;

import br.edu.app.greeting.service.configuration.GreetingConfiguration;
import br.edu.app.greeting.service.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;
//actuator: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html
@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingConfiguration configuration;

    @GetMapping
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        if(name.isEmpty()) {
            name = configuration.getDefaultValue();
        }
        return ResponseEntity.ok(Greeting.builder()
                .id(counter.incrementAndGet())
                .name(String.format(template, configuration.getGreeting(),name))
                .build());
    }
}