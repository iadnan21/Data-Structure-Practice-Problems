package recursion;

public class Rotatedbinarysearch {
    // in rotated binary search the primary goal is same that we have to cheak the target in the array but the additional condition is
    // that we have to cheak the divide array in the cycle first half and the second half
    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6,6,7,8};
    int target = 10;
    int start = 0;
    int end = arr.length-1;
        System.out.println(search(arr, target, start, end));
    }
    public static int search(int[] arr, int target , int start , int end) {
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(arr[mid] == target){
            return mid;
        }
        if (arr[start] <= arr[mid]){
            if(arr[start] <= target && target <= arr[mid]){
                return  search(arr, target, start , mid-1);
            }
            else{
                return search(arr, target, mid + 1, end);
            }
        }
        if(arr[mid] <= arr[end]){
            if(arr[mid] <= target && arr[end] >= target){
                return search(arr, target, mid+1, end);
            }
            else{
                return search(arr, target, start, mid-1);
            }
        }
        return 1;
    }
}
