import array.easy.Problems;
import array.easy.alogorithem.Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] ch = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int[] arr = {3,3,4};
        Sorting sort = new Sorting();
        Problems pb = new Problems();

//        System.out.println(pb.countPrimeNumber(20));
//        System.out.println(pb.searchMatrix(arr,3));
        System.out.println(Arrays.toString(arr));
        System.out.println(pb.majorityElement(arr));
//        System.out.println("-------------------------------");
//        System.out.println(pb.printSpiralMatrix(arr, arr.length, arr[0].length));

////        System.out.println("-------------------------------");
//        pb.rotateImage90Degree(arr);
//        pb.findMaximumInMatrixRow(arr);
//        pb.countSortedRowInMatrix(arr);
//        pb.findCommonElementInMatrixRows(arr);
    }
}