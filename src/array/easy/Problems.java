package array.easy;

import java.lang.reflect.Array;
import java.util.*;

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


    /**
     * 4.print fibonacci series
     */
    public void printFibonacciSeries(int n) {
        int prev = 1;
        int curr = 0;
        for (int i = 0; i <= n; i++) {
            System.out.print(curr + " ");
            int temp = prev;
            prev = curr + temp;
            curr = temp;
        }

    }

    /**
     * 5.Convert decimal number into binary
     */
    public int getBinaryCode(int n) {
        int sum = 0;
        int i = 0;
        while (n != 0) {
            int bit = n % 2;
            sum = (int) (bit * Math.pow(10, i) + sum);
            n = n >> 1;
            i++;
        }
        return sum;
    }

    /**
     * 6.Convert binary number into decimal
     */
    public int convertBinaryToDecimal(int n) {
        int i = 0;
        int num = n;
        int sum = 0;
        while (num != 0) {
            int digit = num % 2;
            sum = (int) (sum + (digit * Math.pow(2, i)));
            num = num / 10;
            i++;
        }
        return sum;
    }

    /**
     * 7.swap alternate array. Ex. = [1,2,3,4,5,6,7,8] -> [2,1,4,3,6,5,8,7]
     */
    public int[] swapAlternateArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }

        return arr;
    }

    /**
     * 8. find unique(non-duplicate) number in an array. Ex. = [2,7,2,8,7,6,8] -> 6
     */

    public void findUniqueNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int uniqueIndex = arr[0];
        for (int item : arr) {
            map.merge(item, 1, Integer::sum);
        }

        for (int item : arr) {
            if (map.get(uniqueIndex) > map.get(item))
                uniqueIndex = item;
        }
        System.out.println(uniqueIndex);
    }

    public int findUniqueNumberTwo(int[] arr) {
        int sum = 0;
        for (int item : arr) {
            sum = sum ^ item;
        }
        return sum;
    }

    /**
     * 9.find unique occurrence in an array [1,2,4,6,7,6,2.3] -> true,  [1,3,3,1] -> false
     */

    public boolean findUniqueOccurrence(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int item : arr) {
            map.merge(item, 1, Integer::sum);
        }
        for (int item : map.values()) {
            if (set.contains(item)) return false;
            else set.add(item);
        }
        return true;
    }

    /**
     * 10.find duplicate number n = 5, [1,2,3,4,5,2]  -> 2
     */

    public int findDuplicateNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int item : arr) {
            if (set.contains(item)) return item;
            else set.add(item);

        }
        return 0;
    }

    /**
     * 11.find duplicate numbers  [1,2,3,4,1,5,2]  -> [1,2]
     */
    public List<Integer> findAllDuplicateValue(int[] arr) {
        List<Integer> list = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int item : arr) {
            if (set.contains(item)) {
                if (!list.contains(item))
                    list.add(item);
            } else {
                set.add(item);
            }
            if (!list.contains(item)) {
                list.add(item);
            }
        }
        return list;
    }

    public List<Integer> findDuplicateNumbersTwo(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int item : arr) {
            map.merge(item, 1, Integer::sum);
        }
        Set<Integer> keys = map.keySet();
        keys.iterator().forEachRemaining((item) -> {
            if (map.get(item) > 1) list.add(item);
        });
        return list;
    }


    /**
     * 12.get first and last occurrence of an element in sorted array [0,1,2,3,3,3,3,3] -> [3,6]
     */
    public int[] getFirstAndLastOccurrence(int[] nums, int target) {
        int[] newArr = {-1,-1};
        int firstOccurrence = -1;
        int lastOccurrence = -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        for (int i =0;i< nums.length;i++){
            if (nums[i] == target){
                mid = i;
                break;
            }
        }
        if (mid == -1){
            return newArr;
        }
        while (start <= end) {
            if (nums[mid] == target) {
                if (firstOccurrence == -1) {
                    firstOccurrence = mid;
                } else {
                    lastOccurrence = mid;
                }
                start = mid + 1;
            }

            if (target < nums[mid]) {
                end = mid - 1;
            }
            if (target > nums[mid]) {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        if (lastOccurrence == -1 && firstOccurrence != -1)
            lastOccurrence = firstOccurrence;
        newArr[0] = firstOccurrence;
        newArr[1] = lastOccurrence;
        return newArr;
    }


}
