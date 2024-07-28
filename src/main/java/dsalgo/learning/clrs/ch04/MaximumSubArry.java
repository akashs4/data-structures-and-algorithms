package dsalgo.learning.clrs.ch04;

public class MaximumSubArry {
    private MaximumSubArry() {
    }

    public static int divideAndConquerMaxSubArray(int[] arr) {
        if (arr.length == 0)
            return 0;
        return helper(arr, 0, arr.length - 1);
    }

    private static int helper(int[] arr, int start, int end) {
        if (start == end)
            return arr[start];
        else {
            int mid = (start + end) / 2;
            int leftMax = helper(arr, start, mid);
            int rightMax = helper(arr, mid + 1, end);
            int crossMax = crossMaxSubArray(arr, start, mid, end);

            if (leftMax >= rightMax && leftMax >= crossMax)
                return leftMax;
            else if (rightMax >= leftMax && rightMax >= crossMax)
                return rightMax;
            else
                return crossMax;
        }
    }

    private static int crossMaxSubArray(int[] arr, int start, int mid, int end) {
        int leftIndex = mid, rightIndex = mid + 1;

        int leftSum = 0, leftMax = arr[mid], rightSum = 0, rightMax = arr[mid + 1];
        for (int i = mid; i >= start; i--) {
            leftSum += arr[i];
            if (leftSum > leftMax) {
                leftMax = leftSum;
                leftIndex = i;
            }
        }

        for (int i = mid + 1; i <= end; i++) {
            rightSum += arr[i];
            if (rightSum > rightMax) {
                rightMax = rightSum;
                rightIndex = i;
            }
        }

        int max = 0;
        for (int i = leftIndex; i <= rightIndex; i++)
            max += arr[i];

        return max;
    }

    public static int bruteForceMaxSubArry(int[] arr) {
        if (arr.length == 0)
            return 0;
        int max = arr[0], n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0, currentMax = arr[i];

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum > currentMax) {
                    currentMax = sum;
                }

            }

            if (currentMax > max) {
                max = currentMax;
            }
        }
        return max;
    }

    public static int linearTimeMaxSubArray(int[] arr) {
        if (arr.length == 0)
            return 0;
        int cSum = arr[0], maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cSum = Math.max(cSum + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, cSum);

            /**
             * check which is larger, arr[i] or cSum+arr[i]
             * whichever is larger is assigned to maxSoFar -> Math.max(maxSoFar, maxEndingHere)
             * */
        }
        return maxSoFar;
    }
}
