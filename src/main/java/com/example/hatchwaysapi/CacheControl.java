package com.example.hatchwaysapi;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.management.timer.Timer;


@EnableCaching
@EnableScheduling
@Configuration
public class CacheControl {
    public static final String cacheEntries = "posts";
    private static final long oneMin = Timer.ONE_HOUR / 60;

    @Scheduled(fixedRate = (oneMin * 5))
    @CacheEvict(value = {cacheEntries}, allEntries = true)
    public void clearEvents() {
        System.out.println(System.currentTimeMillis() + "---Cache cleared");
    }


}
