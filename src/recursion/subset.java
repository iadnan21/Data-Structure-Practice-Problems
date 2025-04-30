package recursion;

import java.util.ArrayList;
import java.util.List;

public class subset {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] arrd = {1,2,2};
        List<List<Integer>> ans = Subset(arr);
        List<List<Integer>> ansd = Subsetduplicate(arrd);
        System.out.println(ans);
        System.out.println(ansd);
    }
                // when we have {1,2,3}
    public static List<List<Integer>> Subset(int[] arr) {
        List<List<Integer>> outerlist = new ArrayList<>(); // it is basically the final list that we get in the output.
        //now create a new list which hold the value or the element of the array.
        outerlist.add(new ArrayList<>());
        for (int num : arr) {
            int n = outerlist.size();
            for (int j = 0; j < n; j++) {
                List<Integer> internalList = new ArrayList<>(outerlist.get(j));
                internalList.add(num);
                outerlist.add(internalList);
            }
        }
        return outerlist;
    }
    // we have {1,2,2}
    public static List<List<Integer>> Subsetduplicate(int[] arr) {
        List<List<Integer>> outerlist = new ArrayList<>(); // it is basically the final list that we get in the output.
        //now create a new list which hold the value or the element of the array.
        outerlist.add(new ArrayList<>());
        int start = 0;
        int end = 0;
        for(int i=0; i<arr.length; i++){
            if(i>0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outerlist.size() - 1;
        }
        for (int num : arr) {
            int n = outerlist.size();
            for (int j = 0; j < n; j++) {
                List<Integer> internalList = new ArrayList<>(outerlist.get(j));
                internalList.add(num);
                outerlist.add(internalList);
            }
        }
        return outerlist;
    }
}