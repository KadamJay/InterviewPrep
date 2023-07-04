package Essential150.Stack;

/*

Problem    :   https://leetcode.com/problems/generate-parentheses/
Solutions  :   https://youtu.be/s9fokUqJ76A
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Stack                                |       O(2^n)   |       O(n)       |

generateParenthesis method:

Time Complexity: O(2^n), where n is the input value. Each position in the result string 
can have two possibilities: "(" or ")".
Space Complexity: O(n), for the recursion stack space.
dfs method:

Time Complexity: O(2^n), where n is the input value. Each position in the result string 
can have two possibilities: "(" or ")".
Space Complexity: O(n), for the recursion stack space.
*/

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, result, 0, 0, "");
        return result;
    }

    private void dfs(int n, List<String> result, int openCount, int closeCount, String tempStr) {
        if (tempStr.length() == 2 * n) {
            result.add(tempStr);
            return;
        }

        if (openCount < n) {
            dfs(n, result, openCount + 1, closeCount, tempStr + "(");
        }
        if (closeCount < openCount) {
            dfs(n, result, openCount, closeCount + 1, tempStr + ")");
        }
    }

    public static void main(String[] args) {
        // Test Case
        GenerateParanthesis generateParenthesis = new GenerateParanthesis();
        List<String> result = generateParenthesis.generateParenthesis(3);
        System.out.println("Generated Parentheses: " + result);
    }
}
