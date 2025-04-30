package recursion;

public class reverseanumber {
    public static void main(String[] args) {
//        reverse(123456);
        System.out.println(reversenew(123456));
//        System.out.println(sum);
    }
    // methhod 1
    static int sum = 0;
    static void reverse(int N){
        if(N==0){
            return;
        }
        int rem = N%10;
        sum = sum * 10 + rem;
         reverse(N/10);
     }
    // method 2 of the reverse number with the helper function
    static int reversenew(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }

    private static int helper(int n, int digits) {
        if(n%10 == n){
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10, digits-1)) + helper(n/10, digits-1);
    }
}
