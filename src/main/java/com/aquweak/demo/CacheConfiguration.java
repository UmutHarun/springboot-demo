package com.aquweak.demo;

import java.util.Arrays;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@EnableScheduling
public class CacheConfiguration {
    
    final static int tenMin = 60000;

    @Bean
    public CacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        cacheManager.setAllowNullValues(false);
        cacheManager.setCacheNames(Arrays.asList("productCache","customerCache"));
        System.out.println("here are the product names " + cacheManager.getCacheNames());
        return cacheManager;
    }

    @CacheEvict(value = "productCache",allEntries = true)
    @Scheduled(fixedDelay = tenMin,initialDelay = 0)
    public void evictProductCache(){
        System.out.println("Evicting Product Cache...");
    }

}
