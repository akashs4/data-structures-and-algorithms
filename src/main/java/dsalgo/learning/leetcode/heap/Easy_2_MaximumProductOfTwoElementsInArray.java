package dsalgo.learning.leetcode.heap;

public class Easy_2_MaximumProductOfTwoElementsInArray {
    public int maxProduct(int[] nums) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if (nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }

        System.out.println("largest: " + largest);
        System.out.println("second largest: " + secondLargest);
        return (largest - 1) * (secondLargest - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3, 7};
        Easy_2_MaximumProductOfTwoElementsInArray obj = new Easy_2_MaximumProductOfTwoElementsInArray();

        System.out.println(obj.maxProduct(nums));
    }
}
