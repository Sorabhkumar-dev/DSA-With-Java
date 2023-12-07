package array.easy;

import javax.swing.*;
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

        if (arr.length < 1) return 0;

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
            if (arr[i] != 0) arr[count++] = arr[i];
        while (count < arr.length) arr[count++] = 0;
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
            if (map.get(uniqueIndex) > map.get(item)) uniqueIndex = item;
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
                if (!list.contains(item)) list.add(item);
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
        int[] newArr = {-1, -1};
        int firstOccurrence = -1;
        int lastOccurrence = -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                mid = i;
                break;
            }
        }
        if (mid == -1) {
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
        if (lastOccurrence == -1 && firstOccurrence != -1) lastOccurrence = firstOccurrence;
        newArr[0] = firstOccurrence;
        newArr[1] = lastOccurrence;
        return newArr;
    }

    /**
     * 13.get first and last occurrence of an element in sorted array [17,18,5,4,6,1] -> [18,6,6,6,1,-1]
     */
    public int[] replaceElements(int[] arr) {
        if (arr.length < 2) return arr;
        int i;
        int maxValue;
        for (i = 0; i < arr.length - 1; i++) {
            int currentIndex = i + 1;
            maxValue = arr[i];
            while (maxValue < arr[currentIndex] && currentIndex < arr.length - 1) {
                maxValue = arr[currentIndex];
                arr[currentIndex] = 0;
                currentIndex++;
            }

            for (int j = currentIndex - 1; i <= j; j--) {
                arr[j] = maxValue;
            }
            maxValue = 0;
            i = currentIndex - 1;
        }
        return arr;
    }

    /**
     * 14.get string first occurrence
     */

    public int getStrFirstOccurrence(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            int lastIndex = i + needle.length();
            if (lastIndex <= haystack.length()) {
                String temp = haystack.substring(i, lastIndex);
                if (temp.equals(needle)) return i;
            } else return -1;
        }
        return -1;
    }

    /**
     * 15. check string is palindrome or not
     */
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * 15. longest palindrome
     */
    public String longestPalindrome(String s) {
        if ((s.length() < 2) || isPalindrome(s)) return s;
        String palindrome = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isPalindrome(temp)) {
                    if (palindrome.length() < temp.length()) palindrome = temp;
                }
            }
        }
        return palindrome;
    }


    /**
     * 15. moveZeroes
     */
    public void moveZeroes1(int[] nums) {
        int k = nums.length - 1;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) {
                nums[i] = Integer.MAX_VALUE;
            }

        for (int i = 0; i < nums.length; i++) {
            int currentMin = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[currentMin]) currentMin = j;
            }
            if (currentMin != i) {
                int temp = nums[currentMin];
                nums[currentMin] = nums[i];
                nums[i] = temp;
            }
        }

        while (nums[k] == Integer.MAX_VALUE) {
            nums[k] = 0;
            k--;
        }
    }

    public void moveZeroes2(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length && nums[j] != 0) {
                    nums[j - 1] = nums[j];
                    j++;
                }
                nums[j - 1] = 0;
            }
        }
    }


    /**
     * 15. rotate array
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int i = 0;
        while (i < k) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
            i++;
        }
    }

    public void rotate2(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(arr, 0, nums, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 15. is array rotated and sorted
     */
    public boolean isArrayRotedSorted(int[] nums) {
        int count = 0;
        int pivot = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                pivot = i;
                if (count > 1) return false;
            }

            if (pivot != -1) {
                int temp = pivot;
                while (temp >= 0) {
                    if (nums[i + 1] > nums[temp]) return false;
                    temp--;
                }
            }
        }

        return true;
    }

    /**
     * 16. check if string is palindrome
     */

    public boolean isPalindromeStr(String s) {
        StringBuilder str = new StringBuilder();
        String newStr = "";
        int j = 0, k;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if ((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z') || Character.isDigit(temp))
                str.append(temp);
        }

        newStr = str.toString().toLowerCase();
        k = newStr.length() - 1;

        while (j <= k) {
            if (newStr.charAt(j) != newStr.charAt(k)) return false;
            k--;
            j++;
        }
        return true;
    }

    /**
     * 17. reverse character array beside empty character
     */
    public char[] reverseStr(char[] str) {
        StringBuilder stringBuilder = new StringBuilder();
        int k = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ' || i == str.length - 1) {
                int j;
                if (str[i] == ' ')
                    j = i - 1;
                else
                    j = i;
                while (j > k) {
                    stringBuilder.append(str[j]);
                    j--;
                }
                if (str[i] == ' ')
                    stringBuilder.append(str[i]);
                k = i;
            }
        }
        for (int i = 0; i < stringBuilder.toString().length(); i++)
            str[i] = stringBuilder.toString().charAt(i);
        return str;
    }

    /**
     * 18. get maximum number of occurrence of particular character in a string
     */
    public char getMaximumOccurrenceChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char maxOccurrence = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i)))
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                map.put(str.charAt(i), 1);
        }

        for (char ch : map.keySet()) {
            if (map.get(ch) > map.get(maxOccurrence))
                maxOccurrence = ch;
        }

        return maxOccurrence;
    }

    //19.Remove string occurrence
    public String removeOccurrences(String s, String part) {
        String temp = s;
        while (!temp.isEmpty() && temp.contains(part)) {
            temp = temp.replaceFirst(part, "");
        }
        return temp;
    }

    //20.Remove duplicate character
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        return stack.toString().replace("[", "").replace("]", "").replaceAll(", ", "");
    }

    //21.compress string
    public int compress(char[] chars) {
        int[] arr = new int[26];
        StringBuilder str = new StringBuilder();
        for (char aChar : chars) {
            arr[aChar - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                str.append((char) (i + 'a'));
            } else if (arr[i] > 1) {
                str.append((char) (i + 'a'));
                str.append(arr[i]);
            }
        }
        char[] newCharArr = str.toString().toCharArray();
        System.arraycopy(newCharArr, 0, chars, 0, str.toString().length());
        return newCharArr.length;
    }

    //23 max row sum
    public List<Integer> twoDimensionalArrayRowSum(int[][] arr) {
        List<Integer> rowSum = new ArrayList<>();
        for (int row = 0; row < arr.length; row++) {
            int sum = 0;
            for (int col = 0; col < arr[row].length; col++) {
                sum += arr[row][col];
            }
            rowSum.add(sum);
        }
        return rowSum;
    }

    //24 max column sum
    public List<Integer> twoDimensionalArrayColumnSum(int[][] arr) {
        List<Integer> columnSum = new ArrayList<>();
        for (int col = 0; col < arr.length; col++) {
            int sum = 0;
            for (int row = 0; row < arr[col].length; row++) {
                sum += arr[row][col];
            }
            columnSum.add(sum);
        }
        return columnSum;
    }

    // 25. print 2D array
    public void print2DArray(int[][] arr) {
        for (int col = 0; col < arr.length; col++) {
            for (int row = 0; row < arr[col].length; row++) {
                System.out.print(arr[row][col] + "  ");
            }
            System.out.println();
        }
    }

    // 26. print wave pattern in 2D array
    public void printInWavePattern(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            if (row % 2 == 0)
                for (int col = 0; col < arr[row].length; col++) {
                    System.out.print(arr[col][row] + "  ");
                }
            else
                for (int col = arr[row].length - 1; col >= 0; col--) {
                    System.out.print(arr[col][row] + "  ");
                }
            System.out.println();
        }
    }

    public void printMatrix(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                if (arr[row][col] <= 9)
                    System.out.print(arr[row][col] + "    ");
                else
                    System.out.print(arr[row][col] + "   ");
            }
            System.out.println();
        }
    }


    // 26. rotate image 90 degree
    public void rotateImage90Degree(int[][] matrix) {
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        while (startColumn < endColumn) {
            for (int row = 0; row < matrix.length; row++) {
                int temp = matrix[row][startColumn];
                matrix[row][startColumn] = matrix[row][endColumn];
                matrix[row][endColumn] = temp;
            }
            startColumn++;
            endColumn--;
        }
        printMatrix(matrix);
    }

    //27. find maximum in row
    public void findMaximumInMatrixRow(int[][] arr) {
        List<Integer> maxRowElements = new ArrayList<>();
        for (int row = 0; row < arr.length; row++) {
            int max = Integer.MIN_VALUE;
            for (int col = 0; col < arr[0].length; col++) {
                if (max < arr[row][col])
                    max = arr[row][col];
            }
            maxRowElements.add(max);
        }
        System.out.println(maxRowElements);
    }

    //28. count sorted row in matrix
    public void countSortedRowInMatrix(int[][] arr) {
        int sortedRow = 0;
        for (int row = 0; row < arr.length; row++) {
            boolean isSortedRow = true;
            for (int col = 1; col < arr[0].length; col++) {
                if (arr[row][col - 1] > arr[row][col]) {
                    isSortedRow = false;
                    break;
                }
            }
            if (isSortedRow)
                sortedRow++;
        }
        System.out.println("Sorted row is ->" + sortedRow);
    }

    // 29. find common element in row in matrix
    public void findCommonElementInMatrixRows(int[][] arr) {
        List<Integer> commonElements = new ArrayList<>();
        List<List<Integer>> rows = new ArrayList<>();
        for (int row = 0; row < arr.length; row++) {
            List<Integer> items = new ArrayList<>();
            for (int col = 0; col < arr[0].length; col++) {
                items.add(arr[row][col]);
            }
            rows.add(items);
        }
        for (int i = 0; i < rows.get(0).size(); i++) {
            boolean isCommonElement = true;
            for (List<Integer> list : rows) {
                if (!list.contains(rows.get(0).get(i))) {
                    isCommonElement = false;
                    break;
                }
            }
            if (isCommonElement)
                commonElements.add(rows.get(0).get(i));
        }

        System.out.println(commonElements);
    }

    // 30. print spiral matrix
    public List<Integer> printSpiralMatrix(int[][] arr, int row, int col) {
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        int total = row * col;

        int startRow = 0;
        int startCol = 0;

        int endRow = row - 1;
        int endCol = col - 1;

        while (count < total) {
            for (int i = startCol; count < total && i <= endCol; i++) {
                ans.add(arr[startRow][i]);
                count++;
            }
            startRow++;
            for (int i = startRow; count < total && i <= endRow; i++) {
                ans.add(arr[i][endCol]);
                count++;
            }
            endCol--;

            for (int i = endCol; count < total && i >= startCol; i--) {
                ans.add(arr[endRow][i]);
                count++;
            }
            endRow--;

            for (int i = endRow; count < total && i >= startRow; i--) {
                ans.add(arr[i][startCol]);
                count++;
            }
            startCol++;
        }

        return ans;
    }

    // 31. print search in matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0;
        int end = row * column - 1;

        int mid = start + (end - start) / 2;

        while (start <= end) {
            int element = matrix[mid / column][mid % column];
            if (target == element)
                return true;
            else if (target < element)
                end = mid - 1;
            else
                start = mid + 1;
            mid = start + (end - start) / 2;
        }

        return false;
    }

    // 32. count prime number
    public int countPrimeNumber(int n) {
        int cnt = 0;
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                cnt++;
                for (int j = i * 2; j < n; j = j + i) {
                    primes[j] = false;
                }
            }
        }
        return cnt;
    }

    // 33. leetcode Qns.1688
    public int numberOfMatches(int n) {
        if (n <= 2) return 1;
        if (n % 2 == 0)
            return n / 2 + numberOfMatches(n / 2);
        else
            return n / 2 + numberOfMatches(n / 2 + 1);
    }

    // 34. leetcode Qns.2264
    public String largestGoodInteger(String num) {
        String largestNum = "";
        for (int i = 0; i < num.length(); i++) {
            if ((i + 2) < num.length() && num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                if (!largestNum.isEmpty() && Integer.parseInt(largestNum) < Integer.parseInt(num.substring(i, i + 3)))
                    largestNum = num.substring(i, i + 3);
                if (largestNum.isEmpty())
                    largestNum = num.substring(i, i + 3);
            }
        }
        return largestNum;
    }

    public String largestOddNumber(String num) {
        for (int i = num.length(); i > 0; i--) {
            if ((num.charAt(i - 1) - '0') % 2 != 0) return num.substring(0, i);
        }
        return "";
    }

    // 36. leetcode Qns.1716
    public int totalMoney(int n) {
        int ans = 0;
        int week = 0;
       while (n > 0){
           for (int i = 1;i<=Math.min(n,7);i++)
               ans = ans + week + i;
           n -= 7;
           week++;

       }
       return ans;
    }

    // 37. leetcode Qns.80
    public int removeDuplicates(int[] nums) {
        int removedElements = 0;
        int uniqueNumber = 0;
        int i = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while (i<nums.length-removedElements){
           if (!map.containsKey(nums[i])) {
               map.put(nums[i], 1);
               uniqueNumber++;
               i++;
           }
           else {
               if (map.get(nums[i]) < 2) {
                   map.put(nums[i], map.get(nums[i]) + 1);
                   uniqueNumber++;
                   i++;
               }
               else{
                   int j = i;
                   while (j < (nums.length - (removedElements+1))) {
                       nums[j] = nums[j + 1];
                       j++;
                   }
                   nums[j] = 0;
                   removedElements++;
               }
           }
        }

        System.out.println(Arrays.toString(nums));

        return uniqueNumber;
    }

    // 37. leetcode Qns 169. Majority Element
    public int majorityElement(int[] nums) {
        int majority = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }

        for(int key:map.keySet()){
            int currentElement = map.get(key);
            if (currentElement > max) {
                max = currentElement;
                majority = key;
            }
        }
        return majority;
    }

    //38. leetcode Qns 121. Best Time to Buy and Sell Stock [7,1,5,3,6,4]
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = Integer.MAX_VALUE;
        for (int price : prices) {
            maxProfit = Math.min(maxProfit, price);
            profit = Math.max(profit, (price - maxProfit));
        }

        return profit;
    }

}
