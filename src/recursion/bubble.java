package recursion;

import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 9, 1, 13, 4, 9};
        bubblesort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubblesort(int[] arr, int length, int index) {
        if (length == 0) {
            return;
        }
        if (index < length) {
            for (int i = arr.length - 1; i >= 0; i--) {
                for (int j = 0; j <= i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                bubblesort(arr, length, index + 1);
            }
        }
    }
}