package recursion;

public class fibonacci {
    public static void main(String[] args) {
        // what is fib
        // 0,1,1,2,3,5,8,13
        for (int i = 0; i < 10 ; i++) {
            System.out.print(fib(i) + " ");
        }
//        fib(50);
    }
    public static int fib(int n){
        if( n == 1 || n == 0){
            return n;
        }
        int result = fib(n-1) + fib(n-2);
        return result;
    }
}
