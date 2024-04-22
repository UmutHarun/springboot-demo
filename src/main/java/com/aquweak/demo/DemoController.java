package com.aquweak.demo;

import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity sayHello(@RequestParam(name = "name", defaultValue = "World") String name) {
        // System.out.println(name);
        // return "Hello, " + name + "!";

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList()); 
    }
}