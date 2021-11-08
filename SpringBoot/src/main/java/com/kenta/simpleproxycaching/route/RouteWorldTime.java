package com.kenta.simpleproxycaching.route;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/time")
public class WorldTime {

    @GetMapping("/test")
    public ResponseEntity<WorldTime> getTime(){
        RestTemplate  restTemplate = new RestTemplate();
        WorldTime result = restTemplate.getForObject("http://worldtimeapi.org/api/timezone/Asia/Bangkok", WorldTime.class);
        System.out.println(result);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
