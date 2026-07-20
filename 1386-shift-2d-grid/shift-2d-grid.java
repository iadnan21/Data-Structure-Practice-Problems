class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        // result arraylist
        List<List<Integer>> result = new ArrayList<>();
        // iternate to each row
        for (int i = 0; i < rows; i++) {
            // for each row, create a arraylist
            List<Integer> currentRow = new ArrayList<>();
            // now for each column index of row add zero(0);
            for (int j = 0; j < cols; j++) {
                currentRow.add(0);
            }
            result.add(currentRow);
        }

        // iterate through the 1D array
        for(int i =0; i < rows; i++){
            for(int j =0; j < cols; j++){
                int currentIndex = i * cols + j;

                int newIndex = ( currentIndex + k ) % (rows * cols);

                int newRow = newIndex / cols;
                int newCol = newIndex % cols;

                result.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return result;
    }
}