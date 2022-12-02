package dsalgo.learning.leetcode.array;

// Problem: https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
public class Easy_2_MaxNumOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int max = 0;

        for (String sentence : sentences) {
            int n = numOfSpaces(sentence) + 1;
            max = Math.max(max, n);
        }

        return max;
    }

    private int numOfSpaces(String sentence) {
        int count = 0;
        int n = sentence.length();
        for (int i = 0; i < n; i++) {
            if (sentence.charAt(i) == ' ')
                count++;
        }
        return count;
    }
}

/*Idea:
 *
 * sentence with max number of space has max number of words
 * */