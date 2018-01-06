package cachingSystem.classes;

import dataStructures.classes.MyLinkedHashMap;
import dataStructures.classes.Pair;

/**
 * This cache is very similar to the FIFOCache, but guarantees O(1) complexity for the get, put and
 * remove operations.
 */
public class LRUCache<K, V> extends ObservableCache<K, V> {
    MyLinkedHashMap<K, V> map = new MyLinkedHashMap<K, V>();

    @Override
    public V get(K key) {
        V value;
        if (map.contains(key)) {
            value = map.get(key);
            map.insertInRoot(key, value);
            cacheListener.onHit(key);
        } else {
            cacheListener.onMiss(key);
            value = null;
        }
        return value;
    }

    @Override
    public void put(K key, V value) {
        map.insertInRoot(key, value);
        clearStaleEntries();
        cacheListener.onPut(key, value);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public V remove(K key) {
        return map.remove(key);
    }

    @Override
    public void clearAll() {
        map.clearAll();
    }

    @Override
    public Pair<K, V> getEldestEntry() {
        if (size() == 0) {
            return null;
        }
        return map.getLast();
    }
}
