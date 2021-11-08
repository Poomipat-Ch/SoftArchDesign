package com.kenta.simpleproxycaching.route;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/time")
public class RouteWorldTime {
    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable(value = "worldTime")
    @RequestMapping(value = "/{area}/{city}", method = RequestMethod.GET)
    public Object getTime(@PathVariable String area, @PathVariable String city){
        Object res = null;
        try {
           res = restTemplate.getForObject("http://worldtimeapi.org/api/timezone/{area}/{city}", Object.class, area, city);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }

    @CacheEvict(value = "worldTime", allEntries = true)
    @RequestMapping(value = "/clear", method = RequestMethod.DELETE)
    public String deleteCache(){
        return "Cache deleted";
    }
}
