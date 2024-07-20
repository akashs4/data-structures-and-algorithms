package dsalgo.learning.leetcode.unionFind;

/**
 * Problem url: https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
 */
public class Medium_1_SmallestEquivalentString {
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        ModifiedUF uf = new ModifiedUF();
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            uf.union(ch1 - 'a', ch2 - 'a');
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < baseStr.length(); i++) {
            char ch = baseStr.charAt(i);
            char requiredChar = (char) ('a' + uf.find(ch - 'a'));
            sb.append(requiredChar);
        }

        return sb.toString();
    }
}

class ModifiedUF {
    private final int NUMBER_OF_ALPHABETS = 26;
    private int[] parent;

    public ModifiedUF() {
        this.parent = new int[26];
        for (int i = 0; i < NUMBER_OF_ALPHABETS; i++)
            parent[i] = i;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ)
            return;

        if (parent[rootP] < parent[rootQ])
            parent[rootQ] = parent[rootP];
        else parent[rootP] = parent[rootQ];
    }

    public int find(int p) {
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }

        while (p != root) {
            int temp = parent[p];
            parent[p] = root;
            p = temp;
        }

        return root;
    }
}
