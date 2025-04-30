package recursion;

public class nknights {
    public static void main(String[] args) {
        int n = 4;
    boolean [][] board = new boolean[n][n];
        nknight(board, 0, 0 , 4);
        return;
    }
    static void nknight(boolean [][] board, int row, int col, int knights){
        // first check the knights are all placed.
        if(knights == 0){
            display(board);
            System.out.println();
            return;
        }
        if(col == board.length && row == board.length-1){
            return;
        }
        if(col == board.length){
            nknight(board, row+1, 0, knights);
            return;
        }
        if(isSafe(board,row,col)){
            board[row][col] = true;
            nknight(board, row, col+1, knights-1);
            board[row][col] = false;
        }
        nknight(board, row, col+1, knights);
    }
   public static boolean isSafe(boolean [][] board, int row, int col){
        // all 4 conditions
       if(isValid(board, row-2, col-1)){
           if(board[row-2][col-1]){
               return false;
           }
       }
       if(isValid(board, row-2, col+1)){
           if(board[row-2][col+1]){
               return false;
           }
       }
       if(isValid(board, row-1, col-2)){
           if(board[row-1][col-2]){
               return false;
           }
       }
       if(isValid(board, row-1, col+2)){
           if(board[row-1][col+2]){
               return false;
           }
       }
       return true;
   }
    // in isValid, check the boundation of the knights.
   public static boolean isValid(boolean[][] board, int row, int col){
       if(row >= 0 && row < board.length-1 && col >= 0 && col < board.length){
           return true;
       }
       return false;
   }
    static void display(boolean [][] board){
        for (boolean[] row : board){
            for (boolean cell : row){
                System.out.print(cell ? "Q" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }
}