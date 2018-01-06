package observerPattern.classes;

import observerPattern.interfaces.CacheListener;

/**
 * The StatsListener collects hit / miss / update stats for a cache.
 *
 * @param <K>
 * @param <V>
 */
public class StatsListener<K, V> implements CacheListener<K, V> {
    int hits = 0;
    int misses = 0;
    int updates = 0;

    /**
     * Get the number of hits for the cache.
     *
     * @return number of hits
     */
    public int getHits() {
        return hits;
    }

    /**
     * Get the number of misses for the cache.
     *
     * @return number of misses
     */
    public int getMisses() {
        return  misses;
    }

    /**
     * Get the number of updates (put operations) for the cache.
     *
     * @return number of updates
     */
    public int getUpdates() {
        return updates;
    }

    @Override
    public void onHit(K key) {
        hits++;
    }

    @Override
    public void onMiss(K key) {
        misses++;
    }

    @Override
    public void onPut(K key, V value) {
        updates++;
    }
}
