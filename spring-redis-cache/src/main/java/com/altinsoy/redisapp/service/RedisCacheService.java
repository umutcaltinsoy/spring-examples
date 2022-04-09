package com.altinsoy.redisapp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheService {

    // This method will cacheable rn
    @Cacheable(cacheNames = "mySpecialCache")
    public String longRunnigMethod() throws InterruptedException{
        Thread.sleep(5000L);
        return "Method started.";
    }

    @CacheEvict(cacheNames = "mySpecialCache")
    public void clearCache() {
        System.out.println("Cache cleared");
    }
}
