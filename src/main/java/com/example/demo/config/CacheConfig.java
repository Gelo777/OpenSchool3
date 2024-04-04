package com.example.demo.config;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public ConcurrentMapCacheManager cacheManager(){
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("booksCache");

        return cacheManager;
    }
}
