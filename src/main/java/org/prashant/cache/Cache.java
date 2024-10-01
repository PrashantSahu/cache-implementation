package org.prashant.cache;

import org.prashant.cache.exceptions.NotFoundException;
import org.prashant.cache.exceptions.StorageFullException;
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
        try {
            this.storage.addKey(key, value);
        } catch (StorageFullException e) {
            Key removeKey = evictionPolicy.evictKey();
            storage.removeKey(removeKey);
        }
        this.evictionPolicy.keyAccessed(key);
    }

    public Value get(Key key) {
        Value value = null;
        try {
         value = this.storage.getValue(key);

            this.evictionPolicy.keyAccessed(key);
        } catch (NotFoundException e) {
            System.out.println(key + " Key not found");
            return null;
        }
        return value;
    }
}
