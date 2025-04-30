package recursion;

import java.util.Scanner;

// binary search function with the correct implememtation of the argument , return type , body of a function
public class BS {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(searchBS(arr, target, 0, arr.length-1));
    }
    static int searchBS(int[] arr, int target, int s, int e){
        if(s > e){
            return -1;
        }
        int middle = s+(e-s)/2;
        if(arr[middle] == target){
            return middle;
        }
        if(target < arr[middle]){
            return searchBS(arr, target, s, middle-1);
        }
        return searchBS(arr, target, middle+1, e);
    }
}
