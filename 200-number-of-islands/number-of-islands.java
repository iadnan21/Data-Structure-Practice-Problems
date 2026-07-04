class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int totalIslands = 0;
        int n = grid.length;
        int rows = grid.length;
        int cols = grid[0].length;
        int [][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    totalIslands++;
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()){
                        int[] node = q.poll();
                        int x = node[0];
                        int y = node[1];

                        if(x < 0 || x>=rows || y<0 || y >= cols || grid[x][y] != '1'){
                            continue;
                        }

                        grid[x][y] = '0';

                        for (int [] direction : directions){
                            int nx = x + direction[0];
                            int ny = y + direction[1];
                            if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == '1'){
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        return totalIslands;
    }
}