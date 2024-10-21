package dsalgo.learning.leetcode.array.easy;

// In place algorithm
public class Easy_7_RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 1;
        }

        int first=0, second=1;

        while(second<n){
            if(nums[first] != nums[second]){
                nums[++first] = nums[second];
            }
            second++;
        }

        System.out.println(first);
        return first;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};

        int x = removeDuplicates(arr);

        System.out.println(x);

    }
}
