import array.easy.Problems;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Problems prob = new Problems();
//        int[] arr = {10, 4, 3, 50, 23, 90};
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
//1.        prob.findLargestThreeNumber(arr);
//2.        System.out.println(prob.findSecondLargestNumber(arr));
        System.out.println(Arrays.toString(prob.moveZeroesToLast(arr)));
    }
}