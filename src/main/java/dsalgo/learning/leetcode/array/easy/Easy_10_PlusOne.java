package dsalgo.learning.leetcode.array.easy;

// Problem: https://leetcode.com/problems/plus-one/description/
public class Easy_10_PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n - 1] == 9) {
            int carry = 0;
            int sum = 0;

            for (int i = n - 1; i >= 0; i--) {
                sum = digits[i] + ((i == n - 1) ? 1 : carry);
                carry = sum / 10;
                digits[i] = sum % 10;
            }

            if (carry > 0) {
                int[] newDigits = new int[n + 1];
                System.arraycopy(digits, 0, newDigits, 1, n);
                newDigits[0] = carry;
                return newDigits;
            }
            return digits;
        } else {
            digits[n - 1] = digits[n - 1] + 1;
            return digits;
        }
    }

    /**
     * sum = digits[i] + (i==n-1) ? 1 : carry
     * carry = sum%10;
     * <p>
     * exit from loop
     * <p>
     * if(carry > 0){
     * create an extra space in front
     * int[] newDigits = new int[n+1];
     * copy values from digits array to newDigits from position 1 to n(for new array)
     * newDigits[0] = carry;
     * return newDigits;
     * }
     */

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
    }
}
