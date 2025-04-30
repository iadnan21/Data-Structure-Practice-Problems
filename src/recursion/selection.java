package recursion;

import java.util.Arrays;

public class selection {
    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 9, 1, 13, 4, 9};
        selectionsort(arr, 0, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionsort(int[] arr, int startindex , int endindex , int maxindex){
        //check the condition of the start > end
        if(startindex >= endindex){
            return;
        }
        // finding the max by linear
        maxindex = startindex;
        for(int i = startindex+1; i <= endindex; i++){
            if(arr[i] > arr[maxindex]){
                // storing only index of max element
                maxindex = i;
            }
            // now just swap that value with the max value
           int temp = arr[maxindex];
            arr[maxindex] = arr[endindex];
            arr[endindex] = temp;
        }
        selectionsort(arr,startindex, endindex-1, maxindex);
    }
}