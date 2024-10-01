package org.prashant.cache.policies;

import org.prashant.data_structure.DoublyLinkedList;
import org.prashant.data_structure.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    DoublyLinkedList<Key> dll;
    Map<Key, DoublyLinkedListNode<Key>> map;

    public LRUEvictionPolicy() {
        dll = new DoublyLinkedList<>();
        map = new HashMap<>();
    }


    @Override
    public void keyAccessed(Key key) {
        if(map.containsKey(key)) {
            DoublyLinkedListNode<Key> node = map.get(key);
            dll.removeNode(node);
            dll.addAtHead(node);
        } else {
            DoublyLinkedListNode<Key> node = new DoublyLinkedListNode<>(key);
            dll.addAtHead(node);
            map.put(key, node);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> node = dll.dummyTail.prev;
        dll.removeNode(node);
        map.remove(node.element);
        return node.element;
    }
}
