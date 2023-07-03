package Essential150.MathGeometry;

class RotateImage {
    public void rotateI(int[][] matrix) {
        int n = matrix.length;

        // Transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        // Swap columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public void rotateII(int[][] matrix) {
        int len = matrix.length;

        int left = 0, right = len - 1;

        while (left < right) {
            int top = left, bottom = right;

            for (int i = 0; i < (right - left); i++) {
                int topLeft = matrix[top][left + i]; // save topleft
                matrix[top][left + i] = matrix[bottom - i][left]; // bottomleft to topleft
                matrix[bottom - i][left] = matrix[bottom][right - i]; // bottomright to bottomleft
                matrix[bottom][right - i] = matrix[top + i][right]; // topright to bottomrigth
                matrix[top + i][right] = topLeft; // topleft to topright
            }

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();

        // Test Case 1
        int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        rotateImage.rotateI(matrix1);
        System.out.println("Rotated Matrix 1:");
        printMatrix(matrix1);

        // Test Case 2
        int[][] matrix2 = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
        rotateImage.rotateII(matrix2);
        System.out.println("Rotated Matrix 2:");
        printMatrix(matrix2);
    }

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
