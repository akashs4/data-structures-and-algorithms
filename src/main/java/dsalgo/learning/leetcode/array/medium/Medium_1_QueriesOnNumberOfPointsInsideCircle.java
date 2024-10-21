package dsalgo.learning.leetcode.array.medium;


// Problem : https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
public class Medium_1_QueriesOnNumberOfPointsInsideCircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int i = 0;

        for (int[] query : queries) {
            for (int[] point : points) {
                if (distance(point[0], point[1], query[0], query[1]) <= query[2] * query[2])
                    answer[i]++;
            }
            i++;
        }

        return answer;
    }

    private int distance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
