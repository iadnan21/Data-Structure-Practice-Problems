package recursion;

public class values {
    public static void main(String[] args) {
//        int a  = 10;
//        int b  = a--;
//        int c = --b;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
        int ans = concept(10);
        System.out.println(ans);
    }
    public static int concept(int n){
        if(n==0){
            return 0;
        }
        System.out.println(n);
        return concept(--n);
    }
}
