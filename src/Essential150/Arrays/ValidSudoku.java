package Essential150.Arrays;

/*
Problem    :   https://leetcode.com/problems/valid-sudoku/
Solutions  :   https://youtu.be/TjFXEUCMqI8
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Set                                  |        O(n^2)        |     O(n^2)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Set+String                           |        O(n^2)        |     O(n^2)       |

https://leetcode.com/problems/valid-sudoku/editorial/

The expression (r / 3) calculates the row index of the sub-box (values 0, 1, or 2) by dividing the current row index r by 3. 
Similarly, c / 3 calculates the column index of the sub-box (values 0, 1, or 2) by dividing the current column index c by 3.

By multiplying (r / 3) by 3, we obtain the starting row index of the sub-box. Adding c / 3 gives us the relative column 
index within the sub-box. Finally, idx stores the overall index of the sub-box, ranging from 0 to 8.

idx = (7 / 3) * 3 + 8 / 3 = 2 * 3 + 2 = 8
idx = (0 / 3) * 3 + 0 / 3 = 0 * 3 + 0 = 0
idx = (4 / 3) * 3 + 4 / 3 = 1 * 3 + 1 = 4

*/
import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    @SuppressWarnings("unchecked")
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}

// With set+strings
class ValidSudokuStrings {
    public boolean isValidSudoku(char[][] board) {
        int N = 9; // It's a 9x9 board
        Set<String> set = new HashSet<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] != '.') {
                    char num = board[r][c];
                    int boxId = (r / 3) * 3 + (c / 3);

                    // Check for duplicates in the same row, column, and box
                    if (!set.add(num + " in row " + r) ||
                            !set.add(num + " in col " + c) ||
                            !set.add(num + " in box " + boxId)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
