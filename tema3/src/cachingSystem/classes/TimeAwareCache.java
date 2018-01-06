package cachingSystem.classes;

import cachingSystem.interfaces.CacheStalePolicy;
import dataStructures.classes.Pair;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * The TimeAwareCache offers the same functionality as the LRUCache, but also stores a timestamp for
 * each element. The timestamp is updated after each get / put operation for a key. This
 * functionality allows for time based cache stale policies (e.g. removing entries that are older
 * than 1 second).
 */
public class TimeAwareCache<K, V> extends LRUCache<K, V> {

    /* TODO: figure out which methods need to overridden in order to implement the timestamp
    functionality */
    private HashMap<K, Timestamp> keyToTimestamp = new HashMap<K, Timestamp>();

    @Override
    public void put(K key, V value) {
        keyToTimestamp.put(key, new Timestamp(System.currentTimeMillis()));
        super.put(key, value);
    }

    @Override
    public V get(K key) {
        clearStaleEntries();
        return super.get(key);
    }

    @Override
    public V remove(K key) {
        keyToTimestamp.remove(key);
        return super.remove(key);
    }

    /**
     * Get the timestamp associated with a key, or null if the key is not stored in the cache.
     *
     * @param key the key
     * @return the timestamp, or null
     */
    public Timestamp getTimestampOfKey(K key) {
        return keyToTimestamp.get(key);
    }

    /**
     * Set a cache stale policy that should remove all elements older than @millisToExpire
     * milliseconds. This is a convenience method for setting a time based polreturn false;icy for the cache.
     *
     * @param millisToExpire the expiration time, in milliseconds
     */
    public void setExpirePolicy(long millisToExpire) {
        if (cacheStalePolicy == null) {
            cacheStalePolicy = new CacheStalePolicy<K, V>() {
                @Override
                public boolean shouldRemoveEldestEntry(Pair<K, V> entry) {
                    return new Timestamp(System.currentTimeMillis()).getTime()
                            - getTimestampOfKey(entry.getKey()).getTime()
                            > millisToExpire;
                }
            };
        }
    }
}
