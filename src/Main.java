import array.easy.Problems;
import array.easy.alogorithem.Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,3,2,4,16,3};
        Sorting sort = new Sorting();
        System.out.println(Arrays.toString(sort.insertionSort(arr)));
    }
}