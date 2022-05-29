package GraphAlgorithms;

/**
 * @author jakadam on 2021-02-25
 */
//https://leetcode.com/problems/shortest-bridge/


/*
In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)



Example 1:

Input: A = [[0,1],[1,0]]
Output: 1
Example 2:

Input: A = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2
Example 3:

Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1


Constraints:

2 <= A.length == A[0].length <= 100
A[i][j] == 0 or A[i][j] == 1
 */


import java.util.*;
class ShortestBridge {

    /**
     * Use DFS + BFS to solve this WONDERFUL problem!
     * Step 1: use DFS to mark the first island to another number
     * Step 2: start from the first island, doing BFS level order traversal to find number of bridges (levels)
     * until reach the second island
     * */
    public int shortestBridge(int[][] A) {
        if (A.length == 0) {
            return 0;
        }

        int n = A.length;
        int m = A[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean marked = false;

        // DFS to mark the all positions of first island to 2
        for (int i = 0; i < n; i++) {
            // WARNING: MUST use a boolean variable to check if we already marked the first island to 2. Otherwise,
            // we will only break from the inner loop, but will not jump out the outer loop
            if (marked) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    // WARNING: MUST add all position of first island into queue as first level, they all can be the
                    // starting points of BFS level order traversal
                    dfs(A, i, j, queue);
                    marked = true;
                    break;
                }
            }
        }

        // BFS level order traversal: to count number of levels before finding the second island
        int bridge = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curPoint = queue.poll();
                int x = curPoint[0];
                int y = curPoint[1];

                // WARNING: CANNOT use if else statement, must use all if statement to check all four directions
                if (x > 0 && A[x - 1][y] == 0) {
                    queue.offer(new int[]{x - 1, y});
                    A[x - 1][y] = 2;
                }
                if (x < n - 1 && A[x + 1][y] == 0) {
                    queue.offer(new int[]{x + 1, y});
                    A[x + 1][y] = 2;
                }
                if (y > 0 && A[x][y - 1] == 0) {
                    queue.offer(new int[]{x, y - 1});
                    A[x][y - 1] = 2;
                }
                if (y < m - 1 && A[x][y + 1] == 0) {
                    queue.offer(new int[]{x, y + 1});
                    A[x][y + 1] = 2;
                }

                // once we find the second island, return current bridge value
                if (x > 0 && A[x - 1][y] == 1 || x < n - 1 && A[x + 1][y] == 1
                        || y > 0 && A[x][y - 1] == 1 || y < m - 1 && A[x][y + 1] == 1) {
                    return bridge;
                }
            }
            bridge++;
        }
        return bridge;
    }

    public void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        queue.offer(new int[]{i, j});
        dfs(grid, i - 1, j, queue);
        dfs(grid, i + 1, j, queue);
        dfs(grid, i, j - 1, queue);
        dfs(grid, i, j + 1, queue);
    }
}
