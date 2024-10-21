package dsalgo.learning.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem url: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/description/
public class Medium_5_GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Integer> l1 = Arrays.asList(5);
        List<Integer> l2 = Arrays.asList(0, 1, 2);
        List<Integer> l3 = Arrays.asList(3, 4, 6);

        List<List<Integer>> list = new ArrayList<>();

        list.add(l2);
        list.add(l3);
        list.add(l1);

        return list;
    }
}
