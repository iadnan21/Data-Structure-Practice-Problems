package recursion;
import java.util.StringJoiner;

public class substring {
    public static void main(String[] args) {
//        System.out.println(skip("", "dinnadnaneve", "adnan"));
        System.out.println(removename("evadnanenfkdo", "adnan"));
    }
//    public static String skip(String p, String up){
//        if(up.isEmpty()){
////            System.out.println(p);
//            return "";
//        }
//
//        char ch = up.charAt(0);
//
//        if(ch == 'a'){
//             return skip(p,up.substring(1));
//        }
//        else{
//            return ch + skip(p+ch, up.substring(1));
//        }
//    }
    public static String removename(String up, String name){
        if(up.isEmpty()){
            return " ";
        }
        if(up.startsWith(name)){
            return removename(up.substring(name.length()),name);
        }
        else{
            return up.charAt(0) + removename(up.substring(1),name);
        }
    }
}
