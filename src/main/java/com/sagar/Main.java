package com.sagar;

import com.sagar.constants.EvictionPolicy;
import com.sagar.model.Cache;
import com.sagar.service.CacheService;

public class Main {

    public static void main(String[] args) {

        CacheService cacheService= CacheService.getInstance();


        Cache cache = cacheService.init(2, EvictionPolicy.LRU);

        cacheService.put("first","First Project Done!!");
        cacheService.put("second","second Project Done!!");
        cacheService.put("third","third Project Done!!");
        cacheService.put("hello","Hello Project Done!!");
        cacheService.delete("hello");

        System.out.println(cacheService.get("first"));
        System.out.println(cacheService.get("second"));
        //cacheService.clear();

        System.out.println(cacheService.get("second"));
        System.out.println(cacheService.get("third"));

    }
}
