package org.prashant;

import org.prashant.cache.Cache;
import org.prashant.cache.factories.CacheFactory;
import org.prashant.cache.policies.EvictionPolicy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cache<String,String> cache = new CacheFactory<String,String>().defaultCache(3);
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4", "four");
        System.out.println(cache.get("1"));
        System.out.println(cache.get("2"));
    }
}