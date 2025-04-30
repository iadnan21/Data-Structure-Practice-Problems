package recursion;

import java.util.ArrayList;

public class subseq {
    public static void main(String[] args) {
        System.out.println(subsequence("abc", ""));
    }
//    static void subsequence(String str, String seq){
//        if(str.isEmpty()){
//            System.out.println(seq);
//            return;
//        }
//        char ch = str.charAt(0);
//        subsequence(str.substring(1), seq + ch);
//        subsequence(str.substring(1), seq);
//    }
        static ArrayList<String> subsequence(String str, String seq){
        if(str.isEmpty()){
            ArrayList<String> al = new ArrayList<>();
            al.add(seq);
            return al;
        }
        char ch = str.charAt(0);
            ArrayList<String> left =  subsequence(str.substring(1), seq + ch);
            ArrayList<String> right = subsequence(str.substring(1), seq);
        left.addAll(right);
        return left;
        }
}
