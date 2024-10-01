package org.prashant.cache.storage;

public interface Storage<Key,Value> {

    public void addKey(Key key, Value value);

    public Value getValue(Key key);

    public void removeKey(Key key);
}
