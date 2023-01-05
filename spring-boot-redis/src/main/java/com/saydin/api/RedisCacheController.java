package com.saydin.api;

import com.saydin.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redisTest")
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCacheService;

    @GetMapping("/cacheAllCountry")
    public String cacheAllCountry() throws InterruptedException {
        return redisCacheService.getAllCountryCache();
    }

    @GetMapping("/cacheAllCity")
    public String cacheAllCity() throws InterruptedException {
        return redisCacheService.getAllCityCache();
    }

    @GetMapping("/clearAllCache")
    public void  clearAllCache(){
         redisCacheService.clearAllCache();
    }

    @GetMapping("/clearCacheCountry")
    public void  clearCacheCountry(){
        redisCacheService.clearCacheCountry();
    }
}
