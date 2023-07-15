package Essential150.Graph;

/*
Problem    :    https://leetcode.com/problems/number-of-islands/
Solutions  :    https://youtu.be/pV2kpPD66nE
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Recursive                            |       O(m*n)         |     O(m*n)       |

*/
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    islandCount++;
                    clearSurroundings(grid, i, j, numRows, numCols);
                }
            }
        }

        return islandCount;
    }

    private void clearSurroundings(char[][] grid, int i, int j, int numRows, int numCols) {
        if (i < 0 || j < 0 || i >= numRows || j >= numCols || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        clearSurroundings(grid, i + 1, j, numRows, numCols);
        clearSurroundings(grid, i, j + 1, numRows, numCols);
        clearSurroundings(grid, i - 1, j, numRows, numCols);
        clearSurroundings(grid, i, j - 1, numRows, numCols);
    }

}
