import array.easy.Problems;
import array.easy.alogorithem.Sorting;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4};
        Sorting sort = new Sorting();
        Problems pb = new Problems();
        System.out.println(pb.isArrayRotedSorted(arr));
    }
}