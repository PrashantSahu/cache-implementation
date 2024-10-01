package org.prashant.cache.storage;

import org.prashant.cache.exceptions.NotFoundException;
import org.prashant.cache.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key,Value> implements Storage<Key, Value>{

    Map<Key,Value> storage;
    int capacity;

    public HashMapStorage(int capacity) {
        this.capacity = capacity;
        storage = new HashMap<>(capacity);
    }


    @Override
    public void addKey(Key key, Value value) throws StorageFullException {
        if(isStorageFull()) throw new StorageFullException("Storage is full");
        storage.put(key,value);
    }

    @Override
    public Value getValue(Key key) throws NotFoundException {
        if(!storage.containsKey(key)) throw new NotFoundException("Key not found");
        return storage.get(key);
    }

    @Override
    public void removeKey(Key key) {
        if(!storage.containsKey(key)) throw new NotFoundException("Key not found");
        storage.remove(key);

    }

    private boolean isStorageFull() {
        return storage.size() >= capacity;
    }
}
