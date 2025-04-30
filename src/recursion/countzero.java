package recursion;

public class countzero {
    public static void main(String[] args) {
        System.out.println(count(1230025656, 0));
    }
    static int count(int n , int cnt){
            if(n==0){
                return cnt;
            }
            int rem = n%10;
            if(rem == 0){
                return count(n/10, cnt+1);
            }
            return count(n/10, cnt);
    }
}
