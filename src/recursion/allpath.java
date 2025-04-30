package recursion;

public class allpath {
    public static void main(String[] args) {
        boolean[][] visited = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        allpath("", visited, 0, 0);
    }
    public static void allpath(String str, boolean [][] visited, int row, int col){
        if (row == visited.length-1 && col == visited[0].length-1){
            System.out.println(str);
            return;
        }
        if(!visited[row][col]){
            return;
        }
        visited[row][col] = false;
        if(row < visited.length-1){
            allpath(str+'D', visited, row+1, col);
        }
        if(col < visited[0].length-1){
            allpath(str+'R', visited, row, col+1);
        }
        if(row > 0){
            allpath(str+'U', visited, row-1, col);
        }
        if(col > 0){
            allpath(str+'L', visited, row, col-1);
        }
        visited[row][col] = true;
        }
    }
