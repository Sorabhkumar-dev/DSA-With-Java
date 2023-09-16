package array.easy;

import java.util.Arrays;

public class Problems {


    /**
     * 1. Find the largest three distinct elements in an array
     * Given an array with all distinct elements, find the largest three elements.
     * Expected time complexity is O(n) and extra space is O(1).
     * Examples :
     * Input: arr[] = {10, 4, 3, 50, 23, 90}
     * Output: 90, 50, 23
     */
    public void findLargestThreeNumber(int[] arr) {
        int temp = 0;
        int low = 0;
        int mid = 0;
        int high = 0;

        if (arr.length <= 3) {
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i : arr) {
                if (i > high) {
                    temp = high;
                    high = i;
                    low = mid;
                    mid = temp;
                    temp = 0;
                } else if (i > mid) {
                    temp = mid;
                    low = temp;
                    mid = i;
                    temp = 0;
                } else if (i > low) {
                    low = i;
                }
            }
            System.out.println("High : " + high + " Mid : " + mid + " Low " + low);
        }
    }

    /**
     * 2. Given an array of integers, our task is to write a program that efficiently finds the second-largest element present in the array.
     * Input: arr[] = {12, 35, 1, 10, 34, 1}
     * Output: The second-largest element is 34.
     * Explanation: The largest element of the
     * array is 35 and the second-largest element is 34
     */
    public int findSecondLargestNumber(int[] arr) {
        int low = 0;
        int high = 0;

        if (arr.length < 1)
            return 0;

        for (int i : arr) {
            if (i > high) {
                low = high;
                high = i;
            }
        }
        return low;
    }

    /**
     * 3.Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
     * For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0},
     * it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The order of all other elements should be same.
     * Expected time complexity is O(n) and extra space is O(1).
     * Examples:-
     * 1.Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
     * Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};
     * 2.Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
     * Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
     */

    public int[] moveZeroesToLast(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];
        while (count < arr.length)
            arr[count++] = 0;
        return arr;
    }

}
