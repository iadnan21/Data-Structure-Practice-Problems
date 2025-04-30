package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class linearsearchrecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,5,5,6,7,8,9,10,11,12};
        int target = 5;
        int index = 0;
        System.out.println(linear(arr, target, index));
        System.out.println(linearindex(arr, target, index));
        System.out.println(linearindexfromLast(arr, target, arr.length-1));
//        findallindex(arr, target, index);
//        System.out.println(list);
        System.out.println(allindex(arr, target,index,list));
        System.out.println(findallindex1(arr, target, index));
    }

    static boolean linear(int[] arr, int target, int index) {
        if (arr.length == index) { // here we are cheaking the every single element
            return false;
        }
        return target == arr[index] || linear(arr, target, index + 1);
    }

    static int linearindex(int[] arr, int target, int index) {
        if (arr.length == index) {
            return -1;
        }
        if (target == arr[index]) {
            return index;
        } else {
            return linearindex(arr, target, index + 1);
        }
    }

    static int linearindexfromLast(int[] arr, int target, int index) {
        if (index == -1) {
            return -1;
        }
        if (target == arr[index]) {
            return arr.length-1 - index;
        } else {
            return linearindexfromLast(arr, target, index - 1);
        }
    }
     static ArrayList<Integer> list = new ArrayList<>();
    static void findallindex(int[] arr, int target, int index) {
        if (index == arr.length) {
            return;
        }
        if (target == arr[index]) {
            list.add(index);
        }
        findallindex(arr, target, index + 1);
    }
    static ArrayList<Integer> allindex(int[] arr, int target, int index , ArrayList<Integer> list) {
        if (index == arr.length) {
            return list;
        }
        if (target == arr[index]) {
            list.add(index);
        }
        return allindex(arr, target, index + 1, list );
    }
    static ArrayList<Integer> findallindex1(int[] arr, int target, int index){
        ArrayList<Integer> list = new ArrayList<>();
      if(index == arr.length){
            return list;
        }
        if(target == arr[index]){
            list.add(index);
        }
        ArrayList<Integer> Bottomcalls = findallindex1(arr, target, index+1);
        list.addAll(Bottomcalls);
        return list;
    }
}
