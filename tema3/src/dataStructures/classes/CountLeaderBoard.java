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
    Rank leastRank;
    Rank highestRank = leastRank;

    public CountLeaderBoard() {
        sentinel = new Ranker();
        sentinel.next = sentinel;
        sentinel.previuos = sentinel;
        leastRank = new Rank(sentinel);
        leastRank.level = 1;
    }

    public void add(E element) {
        Ranker ranker;
        if (allRankers.containsKey(element)) {
            // TODO remove empty ranks
            ranker = allRankers.get(element);
            ranker.previuos.next = ranker.next;
            ranker.next.previuos = ranker.previuos;
            if (ranker.rank.nextRank == null) {
                highestRank = new Rank(sentinel);
                highestRank.previousRank = ranker.rank;
                ranker.rank.nextRank = highestRank;
                highestRank.level = ranker.rank.level + 1;
            }
            ranker.rank = ranker.rank.nextRank;
            ranker.previuos = ranker.rank.lastEnteredRanker;
            ranker.rank.lastEnteredRanker = ranker;
        } else {
            ranker = new Ranker(sentinel);
            ranker.previuos = leastRank.lastEnteredRanker;
            ranker.rank = leastRank;
            ranker.previuos.next = ranker;
            leastRank.lastEnteredRanker = ranker;
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
