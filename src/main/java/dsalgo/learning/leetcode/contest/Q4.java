package dsalgo.learning.leetcode.contest;

//Problem: https://leetcode.com/problems/minimum-addition-to-make-integer-beautiful/
public class Q4 {
    public static void main(String[] args) {
        System.out.println(makeIntegerBeautiful(19, 1));
    }

    private static int sum(long n) {
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }

    public static long makeIntegerBeautiful(long n, int target) {

        int sumOfDigits = sum(n);
        if (sumOfDigits <= target)
            return 0;

        if (n / 10 == 0 && sumOfDigits > target) {
            return 10 - n;
        }

        String num = String.valueOf(n);
        int sum = 0, lastSum = 0, lastIndex = 0;

        for (int i = 0; i < num.length(); i++) {
            lastSum = sum;
            sum += num.charAt(i) - '0';

            if (sum > target) {
                break;
            }

            lastIndex = i;
        }

        int size = num.length();
        StringBuffer sb = new StringBuffer("0");
        StringBuffer sb1 = new StringBuffer("1");
        for (int i = 0; i <= lastIndex; i++) {
            sb.append(num.charAt(i));
        }

        for (int i = lastIndex + 1; i < size; i++) {
            sb.append(0);
            sb1.append(0);
        }

        long num1 = Long.parseLong(sb.toString());
        long diff = Long.parseLong(sb1.toString());

        System.out.println("num1: " + num1);
        System.out.println("diff: " + diff);


        long newNum = num1 + diff;

        System.out.println("new num: " + newNum);

        if (sum(newNum) <= target)
            return newNum - n;
        else return newNum - n + makeIntegerBeautiful(newNum, target);
    }
}
