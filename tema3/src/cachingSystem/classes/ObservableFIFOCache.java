package cachingSystem.classes;

import dataStructures.classes.Pair;

/**
 * Class that adapts the FIFOCache class to the ObservableCache abstract class.
 */
public class ObservableFIFOCache<K, V> extends ObservableCache<K, V> {

    FIFOCache<K, V> fifoCache = new FIFOCache<>();

    @Override
    public V get(K key) {
        V returnValue = fifoCache.get(key);
        if (returnValue == null) {
            cacheListener.onMiss(key);
        } else {
            cacheListener.onHit(key);
        }
        return returnValue;
    }

    @Override
    public void put(K key, V value) {
        fifoCache.put(key, value);
        clearStaleEntries();
        cacheListener.onPut(key, value);
    }

    @Override
    public int size() {
        return fifoCache.size();
    }

    @Override
    public boolean isEmpty() {
        return fifoCache.isEmpty();
    }

    @Override
    public V remove(K key) {
        return fifoCache.remove(key);
    }

    @Override
    public void clearAll() {
        fifoCache.clearAll();
    }

    @Override
    public Pair<K, V> getEldestEntry() {
        return fifoCache.getEldestEntry();
    }

    /* TODO: implement the methods from ObservableCache and Cache */

    /* TODO: when adding a new key (the put method), don't forget to call clearStaleEntries */
}
