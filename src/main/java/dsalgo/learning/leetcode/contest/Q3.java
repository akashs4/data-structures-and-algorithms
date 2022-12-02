package dsalgo.learning.leetcode.contest;

import java.util.*;
import java.util.stream.Collectors;

public class Q3 {
    public static void main(String[] args) {
        String[] creators = {"alice", "alice", "alice"};
        String[] ids = {"a", "b", "c"};
        int[] views = {1, 2, 2};

        mostPopularCreator(creators, ids, views);
    }

    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, List<Integer>> creatorDetails = new HashMap<>();
        Map<String, Integer> popularities = new HashMap<>();
        Map<String, TreeSet<String>> maxIDs = new HashMap<>();
        Map<String, Integer> maxViews = new HashMap<>();

        int n = creators.length;
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            int popularity = 0;

            if (!creatorDetails.containsKey(creators[i])) {
                temp.add(i);
            } else {
                temp = creatorDetails.get(creators[i]);
                temp.add(i);
                popularity = popularities.get(creators[i]);
            }

            final int index = i;
            int lastMax = 0;

            if (maxViews.get(creators[i]) != null)
                lastMax = maxViews.get(creators[i]);

            if (!maxIDs.containsKey(creators[i])) {
                TreeSet<String> set = new TreeSet<>();
                set.add(ids[i]);
                maxIDs.put(creators[i], set);
            } else {
                TreeSet<String> set = new TreeSet<>();
                set = maxIDs.get(creators[i]);

                if (views[i] > lastMax) {
                    set.clear();
                    set.add(ids[i]);

                } else if (views[i] == lastMax) {
                    set.add(ids[i]);
                }
                maxIDs.put(creators[i], set);
            }

            popularity += views[i];

            maxViews.compute(creators[i], (k, v) -> (v == null) ? views[index] : Math.max(v, views[index]));
            creatorDetails.put(creators[i], temp);
            popularities.put(creators[i], popularity);
        }

        System.out.println(maxIDs);
        System.out.println(maxViews);

        int maxPopularity = 0;
        for (String creator : creatorDetails.keySet()) {
            maxPopularity = Math.max(maxPopularity, popularities.get(creator));
        }

        final int max = maxPopularity;

        List<String> popularCreators = popularities.entrySet().stream().filter(entry -> entry.getValue() == max).map(entry -> entry.getKey()).collect(Collectors.toList());
        // iterate over popularities and store those keys where entry's value is equal to max popularity in separate string
//        for (Map.Entry<String, Integer> entry : popularities.entrySet()) {
//            if (entry.getValue() == maxPopularity)
//                popularCreators.add(entry.getKey());
//        }

        List<List<String>> result = new ArrayList<>();
        for (String creator : popularCreators) {
            result.add(Arrays.asList(creator, maxIDs.get(creator).first()));
        }


        return result;
    }

    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;

        return totalCost;
    }
}

class MinCost implements Comparable<MinCost> {
    int cost;
    int index;

    @Override
    public int compareTo(MinCost other) {
        if (other.cost == this.cost)
            return this.index - other.index;
        return this.cost - other.cost;
    }
}

/*
 * idea:
 * create map: <String, List<Integer>> -> contains creater name, list of indices of video IDs
 * one iteration to find creator with max popularity by storing this in new treemap (key=popularity, value:list of names)
 * another iteration on value of that creator and store (number of views, TreeSet<String> of id as key, value in treemap
 * extract first entry's value and from value again first entry -> gives id of video with max views
 * */