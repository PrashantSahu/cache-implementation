package org.prashant;

import org.prashant.cache.Cache;
import org.prashant.cache.factories.CacheFactory;
import org.prashant.cache.policies.EvictionPolicy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cache<String,String> cache = new CacheFactory<String,String>().defaultCache(5);
        cache.put("1", "one");
        cache.get("1");
    }
}