package Arrays;

/*
 *  Given a 2D integer array matrix, return the transpose of matrix.

    The transpose of a matrix is the matrix flipped over its main diagonal, 
    switching the matrix's row and column indices.

    Example 1:

    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[1,4,7],[2,5,8],[3,6,9]]

    Example 2:

    Input: matrix = [[1,2,3],[4,5,6]]
    Output: [[1,4],[2,5],[3,6]]
*/

/*
 * Original Question:

    Time complexity: O(n*m)
    Space complexity: O(n*m) for the output matrix.
 */

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] transposedMatrix = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                transposedMatrix[i][j] = matrix[j][i];

        return transposedMatrix;
    }

}

/*
 * Follow-up for square matrices:
 * 
 * Time complexity: O(n*m)
 * Space complexity: O(1)
 * 
 * we want to make sure we're only swapping i and j once. Therefore, start our
 * nested for-loop
 * at j = i+1 (the "+1" is there since we can skip the diagonals as well).
 */

class TransposeMatrixSquare {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }
}