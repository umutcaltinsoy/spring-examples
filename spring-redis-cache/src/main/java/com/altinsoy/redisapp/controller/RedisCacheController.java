package com.altinsoy.redisapp.controller;

import com.altinsoy.redisapp.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCacheService;

    private int sayac = 0;
    @GetMapping
    public String cacheControl() throws InterruptedException {
        if (sayac == 5) {
            redisCacheService.clearCache();
            sayac = 0;
        }
        sayac++;
        return redisCacheService.longRunnigMethod();
    }
}
