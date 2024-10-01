package org.prashant.cache.factories;

import org.prashant.cache.Cache;
import org.prashant.cache.policies.LRUEvictionPolicy;
import org.prashant.cache.storage.HashMapStorage;

public class CacheFactory<Key,Value> {

    public Cache<Key,Value> defaultCache(int capacity) {
        return new Cache<>(new LRUEvictionPolicy<>(), new HashMapStorage<>(capacity));
    }
}
