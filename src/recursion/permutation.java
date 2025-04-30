package recursion;

import java.util.*;

public class permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(permute(arr));
    }
    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> outerlist = new ArrayList<>();
////        outerlist.add(new ArrayList<>());
////
////        for(int num : nums){
////            int n = outerlist.size();
////            for(int i=0; i<n; i++){
////                List<Integer> temp = outerlist.remove(0);
////                for(int j=0; j<=temp.size(); j++){
////                    List<Integer> internalist = new ArrayList<>(temp);
////                    //add the next element of array in the first position of internalist
////                    internalist.add(j,num);
////                    outerlist.add(internalist);
////                }
////            }
////        }
////        return outerlist;

        // duplicate array
        Arrays.sort(nums);
        List<List<Integer>> outerlist = new ArrayList<>();
        outerlist.add(new ArrayList<>());

        for(int num : nums){
            Set<List<Integer>> outerset = new HashSet<>();
            for(List<Integer> temp : outerlist){
                for(int j=0; j<=temp.size(); j++){
                    List<Integer> internalist = new ArrayList<>(temp);
                    //add the next element of array in the first position of internalist
                    internalist.add(j,num);
                    outerset.add(internalist); // add only unique element
                }
                outerlist = new ArrayList<>(outerset);
            }
        }
        return outerlist;
    }
    }
