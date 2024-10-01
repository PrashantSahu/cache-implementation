package org.prashant.cache;

import org.prashant.cache.policies.EvictionPolicy;
import org.prashant.cache.storage.Storage;

public class Cache<Key,Value> {

    private final Storage<Key,Value> storage;

    private final EvictionPolicy<Key> evictionPolicy;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        this.storage.addKey(key, value);
        this.evictionPolicy.keyAccessed(key);
    }

    public Value get(Key key) {
        Value value = this.storage.getValue(key);
        if (value != null) {
            this.evictionPolicy.keyAccessed(key);
        }
        return value;
    }
}
