package Essential150.MathGeometry;

/*

Problem    :   https://leetcode.com/problems/set-matrix-zeroes/
Solutions  :   https://youtu.be/T41rL0L3Pnw
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Traversal                            |       O(m*n)    |       O(1)       |

Space complexity can be reduced from m*n [copy array] to (m+n)[two 1D array] to constant
2 vars(1 each for 1st row and 1st col).

*/
class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstRowZero = true;
                    if (j == 0)
                        firstColZero = true;

                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }
        // Set rows and columns to zeros based on markers
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numCols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the first row and column to zeros if necessary
        if (firstRowZero) {
            for (int j = 0; j < numCols; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < numRows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros smz = new SetMatrixZeros();

        // Test cases
        int[][] matrix1 = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        smz.setZeroes(matrix1);
        printMatrix(matrix1);

        int[][] matrix2 = {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        smz.setZeroes(matrix2);
        printMatrix(matrix2);

        int[][] matrix3 = {
                { 1, 1, 1 },
                { 0, 1, 2 }
        };
        smz.setZeroes(matrix3);
        printMatrix(matrix3);
    }

    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
