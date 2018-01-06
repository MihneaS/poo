package observerPattern.classes;

import java.util.List;

import dataStructures.classes.CountLeaderBoard;
import observerPattern.interfaces.CacheListener;

/**
 * The KeyStatsListener collects key-level stats for cache operations.
 *
 * @param <K>
 * @param <V>
 */
public class KeyStatsListener<K, V> implements CacheListener<K, V> {

    CountLeaderBoard<K> hits = new CountLeaderBoard<K>();
    CountLeaderBoard<K> misses = new CountLeaderBoard<K>();
    CountLeaderBoard<K> updates = new CountLeaderBoard<K>();

    /**
     * Get the number of hits for a key.
     *
     * @param key the key
     * @return number of hits
     */
    public int getKeyHits(K key) {
        return hits.get(key);
    }

    /**
     * Get the number of misses for a key.
     *
     * @param key the key
     * @return number of misses
     */
    public int getKeyMisses(K key) {
        return misses.get(key);
    }

    /**
     * Get the number of updates for a key.
     *
     * @param key the key
     * @return number of updates
     */
    public int getKeyUpdates(K key) {
        return updates.get(key);
    }

    /**
     * Get the @top most hit keys.
     *
     * @param top number of top keys
     * @return the list of keys
     */
    public List<K> getTopHitKeys(int top) {
        return hits.getTop(top);
    }

    /**
     * Get the @top most missed keys.
     *
     * @param top number of top keys
     * @return the list of keys
     */
    public List<K> getTopMissedKeys(int top) {
        return misses.getTop(top);
    }

    /**
     * Get the @top most updated keys.
     *
     * @param top number of top keys
     * @return the list of keys
     */
    public List<K> getTopUpdatedKeys(int top) {
        return updates.getTop(top);
    }

    @Override
    public void onHit(K key) {
        hits.add(key);
    }

    @Override
    public void onMiss(K key) {
        misses.add(key);

    }

    @Override
    public void onPut(K key, V value) {
        updates.add(key);
    }
}
