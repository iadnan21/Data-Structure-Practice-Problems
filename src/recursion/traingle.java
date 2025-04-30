package recursion;

public class traingle {
    public static void main(String[] args) {
    trainglepattern(4,0);
    }
    public static void trainglepattern(int r, int c){
        if(r == 0){
            return;
        }
        if(r > c){
//            System.out.print("*");
            trainglepattern(r, c+1);
            System.out.print("*");

        }
        else{
//            System.out.println();
            trainglepattern(r-1, 0);
            System.out.println();
        }
    }
}
