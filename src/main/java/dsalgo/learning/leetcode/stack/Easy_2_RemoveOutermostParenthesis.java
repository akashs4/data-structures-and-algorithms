package dsalgo.learning.leetcode.stack;

// Problem url: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
public class Easy_2_RemoveOutermostParenthesis {

    public String removeOuterParenthesis(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (count > 0) {
                    sb.append("(");
                }
                count++;
            } else {
                if (count > 1) {
                    sb.append(")");
                }
                count--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String expression = "((()())(()()))";
        String expression2 = "((()))";
        String expression3 = "";
        String expression4 = "(()()()())";
        Easy_2_RemoveOutermostParenthesis obj = new Easy_2_RemoveOutermostParenthesis();
        System.out.println(obj.removeOuterParenthesis(expression));
        System.out.println(obj.removeOuterParenthesis(expression2));
        System.out.println(obj.removeOuterParenthesis(expression3));
        System.out.println(obj.removeOuterParenthesis(expression4));
    }
}
