package recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println("hello welcome to recursion lesson");
        // print from 1 to N
        int N = 15;
        int i = 1;
//        printfcn(i , N);
//        printreversefcn(N);
        int ans =  digitsum(102566);
        System.out.println(ans);
    }

    private static void printreversefcn(int N) {
        if(N < 1){
            return;
        }
        System.out.println(N);
        printreversefcn(N-1);
    }

    public static void printfcn(int i , int N){
        if(i > N){
            return;
        }
        System.out.println(i);
        printfcn(i+1, N);
    }
    public static int digitsum(int N){
        if(N <= 1){
            return N;
        }
        return (N%10) + digitsum(N/10);
    }
    }