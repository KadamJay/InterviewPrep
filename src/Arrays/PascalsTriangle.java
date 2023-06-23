package Arrays;

import java.util.ArrayList;

/*
 *  Input Format: N = 5

    Result:
        1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1

    Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.

    Input Format: N = 1

    Result: 
        1
 */
public class PascalsTriangle {
    public static void main(String args[]) {
        int numRows = 5;
        ArrayList<ArrayList<Integer>> res;
        PascalsTriangleSolver solver = new PascalsTriangleSolver();
        res = solver.solve(numRows);
        // print the pascal trianglex
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println("\n");
        }
    }
}

class PascalsTriangleSolver {
    public ArrayList<ArrayList<Integer>> solve(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> inner = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    inner.add(1);
                } else {
                    inner.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(inner);
        }
        return res;
    }
}
