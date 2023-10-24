package array.easy.alogorithem;

public class Sorting {
    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-(i+1); j++) {
               if (arr[j+1] < arr[j]){
                   int temp = arr[j+1];
                   arr[j+1] = arr[j];
                   arr[j] = temp;
               }
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int currentMin = i;
            for (int j = i; j < arr.length; j++) {
               if (arr[j] < arr[currentMin])currentMin = j;
            }
            if (currentMin != i){
                int temp = arr[currentMin];
                arr[currentMin] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public int[] insertionSort(int[] arr){
        for (int i = 1; i< arr.length;i++){
            int temp = arr[i];
            int j = i-1;
            for (;j>0;j--){
                if (arr[j] > temp)
                  arr[j+1] = arr[j];
                else
                    break;

            }
            arr[j+1] = temp;
        }
        return arr;
    }
}
