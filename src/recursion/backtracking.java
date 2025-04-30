package recursion;

public class backtracking {
    public static void main(String[] args) {
        boolean[][] visited = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        maze("", visited, 0, 0);
    }
    public static void maze(String p, boolean[][] visited, int row, int col){
        if(row == visited.length-1 && col == visited[0].length-1){
            System.out.println(p);
            return;
        }
        if(!visited[row][col] && row==col){
            return;
        }
        if(row < visited.length-1){
            maze(p+'D', visited, row+1, col);
        }
        if(col < visited[0].length-1){
            maze(p+'R', visited, row, col+1);
            // in all four directions
            if(row > 0){
                maze(p+'U', visited, row-1, col);
            }
            if(col > 0){
                maze(p+'L', visited, row, col-1);
            }
        }
    }
}
