import array.easy.Problems;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Problems prob = new Problems();
       int[] arr = {1};
        System.out.println(arr.length);
        System.out.println(Arrays.toString(prob.getFirstAndLastOccurrence(arr,1)));
    }


}