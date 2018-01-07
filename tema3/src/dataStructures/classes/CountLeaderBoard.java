package dataStructures.classes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Creates an leaderboard based on the frecuency of each element
 * on the same frequency, items are kept in revers-inserted order (tho the structer can be easily modified to do the opposite
 * add and getTop operation have O(1) time complexity
 */
public class CountLeaderBoard<E> {

    class Rank {
        int level;
        Ranker lastEnteredRanker;
        Rank nextRank;
        Rank previousRank;

        Rank(Ranker sentinel) {
            lastEnteredRanker = sentinel;
        }

        public Rank() { }
    }

    class Ranker{
        Rank rank;
        Ranker previuos;
        Ranker next;
        E element;

        Ranker() { }

        Ranker(Ranker sentinel) {
            previuos = sentinel;
            next = sentinel;
        }
    }

    HashMap<E, Ranker> allRankers = new HashMap<E, Ranker>();
    Ranker sentinel;
    Rank bottomRank;
    Rank highestRank = bottomRank;
    Rank sentinelRank;

    public CountLeaderBoard() {
        sentinel = new Ranker();
        sentinelRank = new Rank();
        sentinel.next = sentinel;
        sentinel.previuos = sentinel;
        bottomRank = new Rank(sentinel);
        bottomRank.level = 1;
        bottomRank.nextRank = sentinelRank;
        sentinelRank.level = Integer.MAX_VALUE;
    }

    public void add(E element) {
        Ranker ranker;
        if (allRankers.containsKey(element)) {
            // get ranker
            ranker = allRankers.get(element);
            // take him out from current rank
            ranker.previuos.next = ranker.next;
            ranker.next.previuos = ranker.previuos;
            // create and insert next rank if necesearry
            if (ranker.rank.nextRank.level - ranker.rank.level > 1) {
                Rank newRank = new Rank(sentinel);
                newRank.nextRank = ranker.rank.nextRank;
                newRank.previousRank = ranker.rank;
                ranker.rank.nextRank = newRank;
                newRank.level = ranker.rank.level + 1;
                if (newRank.nextRank == sentinelRank) {
                    highestRank = newRank;
                }
            }
            // delete rank if empty and not bottom rank
            if (ranker.rank != bottomRank) {
                Rank prevRank = ranker.rank.previousRank;
                if (prevRank.lastEnteredRanker == sentinel
                        && prevRank != bottomRank) {
                    prevRank.previousRank.nextRank = prevRank.nextRank;
                    prevRank.nextRank.previousRank = prevRank.previousRank;
                }
            }
            // insert ranker at the begginig of the next rank
            ranker.rank = ranker.rank.nextRank;
            ranker.previuos = ranker.rank.lastEnteredRanker;
            ranker.rank.lastEnteredRanker = ranker;
        } else {
            ranker = new Ranker(sentinel);
            ranker.previuos = bottomRank.lastEnteredRanker;
            ranker.rank = bottomRank;
            ranker.previuos.next = ranker;
            bottomRank.lastEnteredRanker = ranker;
            allRankers.put(element, ranker);
        }
    }

    public List<E> getTop(int nr) {
        Rank rank = highestRank;
        Ranker ranker;
        List<E> top = new LinkedList<E>();
        while (nr != 0 && rank != null) {
            ranker = highestRank.lastEnteredRanker;
            while (ranker != sentinel) {
                top.add(ranker.element);
                nr--;
            }
            rank = rank.previousRank;
        }
        return top;
    }

    public int get(E element) {
        if (allRankers.containsKey(element)) {
            return allRankers.get(element).rank.level;
        }
        return 0;
    }
}
