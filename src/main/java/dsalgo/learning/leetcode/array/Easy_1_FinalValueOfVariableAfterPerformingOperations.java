package dsalgo.learning.leetcode.array;

// Problem: https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
public class Easy_1_FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int value = 0;

        for (String operation : operations) {
            if (operation.charAt(0) == 'X') {
                // either plus or minus now
                if (operation.charAt(1) == '+')
                    value++;
                else value--;
            } else if (operation.charAt(0) == '+')
                value++;
            else value--;
        }

        return value;
    }
}

/*Idea:
 * Compare only the characters, since it'll save time
 * because there are only 4 possible operations:
 * X++, X--
 * ++X, --X
 * */
