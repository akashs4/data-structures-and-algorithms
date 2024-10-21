package dsalgo.learning.leetcode.stack;

import java.util.Stack;

// Problem url: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
public class Easy_1_MaximumNestingDepthOfParenthesis {
    public int maxDepth(String s) {
        int maxSize = 0;
        Stack<Character> bracesStack = new Stack<>();
        char[] expression = s.toCharArray();

        for (Character ch : expression) {
            if (ch == '(') {
                bracesStack.push(ch);
                maxSize = Math.max(maxSize, bracesStack.size());
            } else if (ch == ')')
                bracesStack.pop();
        }

        return maxSize;
    }
}
