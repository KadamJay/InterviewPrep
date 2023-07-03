package Essential150.MathGeometry;

/*

Problem    :   https://leetcode.com/problems/spiral-matrix/
Solutions  :   https://youtu.be/BJnMZNwUk1M
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Traversal                            |       O(n^2)    |       O(1)       |

*/
import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public List<Integer> getSpiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0)
            return result;

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int top = 0, bottom = numRows - 1, left = 0, right = numCols - 1;
        int direction = 0;

        while (top <= bottom && left <= right) {
            if (direction == 0) {
                // Traverse from left to right
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;
                direction = 1;
            } else if (direction == 1) {
                // Traverse from top to bottom
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
                direction = 2;
            } else if (direction == 2) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
                direction = 3;
            } else if (direction == 3) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
                direction = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();

        // Test Case 1
        int[][] matrix1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        List<Integer> result1 = spiralMatrix.getSpiralOrder(matrix1);
        if (result1.equals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5))) {
            System.out.println("Test Case 1 Passed!");
        } else {
            System.out.println("Test Case 1 Failed!");
        }

        // Test Case 2
        int[][] matrix2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        List<Integer> result2 = spiralMatrix.getSpiralOrder(matrix2);
        if (result2.equals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))) {
            System.out.println("Test Case 2 Passed!");
        } else {
            System.out.println("Test Case 2 Failed!");
        }
    }

}
