import array.easy.Problems;
import array.easy.alogorithem.Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] ch = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Sorting sort = new Sorting();
        Problems pb = new Problems();

        System.out.println(pb.searchMatrix(arr,3));;
//        System.out.println("-------------------------------");
//        System.out.println(pb.printSpiralMatrix(arr, arr.length, arr[0].length));

////        System.out.println("-------------------------------");
//        pb.rotateImage90Degree(arr);
//        pb.findMaximumInMatrixRow(arr);
//        pb.countSortedRowInMatrix(arr);
//        pb.findCommonElementInMatrixRows(arr);
    }
}