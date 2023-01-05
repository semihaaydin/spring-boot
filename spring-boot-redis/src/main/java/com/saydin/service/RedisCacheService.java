package com.saydin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    Logger logger= LoggerFactory.getLogger(RedisCacheService.class);

    @Cacheable(cacheNames = "allCityCache")
    public String getAllCityCache() throws InterruptedException {
            Thread.sleep(15000L);
             logger.info("allCityCache is load");
             return "allCityCache is running";
    }

    @Cacheable(cacheNames = "allCountryCache")
    public String getAllCountryCache() throws InterruptedException {
        Thread.sleep(5000L);
        logger.info("allCountryCache is load");
        return "allCountryCache is running";
    }

    @CacheEvict(allEntries = true)
    public void clearAllCache(){
        logger.info("Clear all cache");
    }

    @CacheEvict(cacheNames ="allCountryCache")
    public void clearCacheCountry(){
        logger.info("Clear Country cache");
    }

}
