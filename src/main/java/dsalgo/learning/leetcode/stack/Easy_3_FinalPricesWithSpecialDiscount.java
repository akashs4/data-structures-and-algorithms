package dsalgo.learning.leetcode.stack;

import java.util.Stack;

// Problem url: https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
public class Easy_3_FinalPricesWithSpecialDiscount {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int n = prices.length;
        int[] finalPrices = new int[n];

        for (int i = 0; i < n; ) {
            if (stack.isEmpty())
                stack.push(i++);
            else {
                if (prices[i] > prices[stack.peek()]) {
                    stack.push(i++);
                } else {
                    while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                        int index = stack.pop();
                        finalPrices[index] = prices[i];
                    }
                    stack.push(i++);
                }
            }
        }

        System.out.println("next smallest elements for each index are");
        for (int num : finalPrices)
            System.out.print(num + " ");

        for (int i = 0; i < n; i++) {
            finalPrices[i] = prices[i] - finalPrices[i];
        }

        return finalPrices;
    }

    public static void main(String[] args) {
        Easy_3_FinalPricesWithSpecialDiscount obj = new Easy_3_FinalPricesWithSpecialDiscount();
        int[] arr = {8, 4, 6, 2, 3};
        obj.finalPrices(arr);
    }
}

/**
 * 2 possibilities: push or pop
 * if smaller number
 * pop
 * if greater number or empty stack
 * push
 * <p>
 * <p>
 * Optimized way
 * <p>
 * next smallest
 * <p>
 * 8
 * insertin 4, smaller than 8, pop 8, insert 4 index
 * mark next smallest for 8 as 4
 * <p>
 * 8 4 6 2 3
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 * <p>
 * <p>
 * int[] result = new int[arr.length];
 * <p>
 * for(i=0 to n-1){
 * result[i] = findDiscount(arr, i);
 * }
 * <p>
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 * if(arr[i] <= val){
 * discount = arr[i];
 * break;
 * }
 * }
 * <p>
 * return discount;
 */

/**
 *
 * int[] result = new int[arr.length];
 *
 * for(i=0 to n-1){
 *     result[i] = findDiscount(arr, i);
 * }
 *
 * findDiscount(arr, index)
 * val -> arr[index]
 * discount = 0;
 * for(i=index+1 to n-1){
 *     if(arr[i] <= val){
 *         discount = arr[i];
 *         break;
 *     }
 * }
 *
 * return discount;
 *
 * */
