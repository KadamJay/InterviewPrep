package Essential150.Stack;

/*

Problem    :   https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
Solutions  :   https://youtu.be/iu0082c4HDE
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Stack                                |       O(n)      |       O(n)       |

Time complexity: O(n), where n is the number of tokens in the input.
Space complexity: O(n), as the stack is used to store intermediate results.
*/

import java.util.Stack;

class EvalRevPolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            int num1, num2;
            switch (token) {
                case "+":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                case "-":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                case "*":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        EvalRevPolishNotation solution = new EvalRevPolishNotation();

        // Test case 1: Example case
        String[] tokens1 = { "2", "1", "+", "3", "*" };
        int result1 = solution.evalRPN(tokens1);
        System.out.println("Test case 1: " + result1); // Expected output: 9

        // Test case 2: Division with negative operands
        String[] tokens2 = { "4", "13", "5", "/", "+" };
        int result2 = solution.evalRPN(tokens2);
        System.out.println("Test case 2: " + result2); // Expected output: 6

        // Test case 3: Single token
        String[] tokens3 = { "42" };
        int result3 = solution.evalRPN(tokens3);
        System.out.println("Test case 3: " + result3); // Expected output: 42

        // Test case 4: Large expression
        String[] tokens4 = { "3", "4", "+", "2", "*", "1", "5", "-", "2", "3", "^", "^", "/", "+" };
        int result4 = solution.evalRPN(tokens4);
        System.out.println("Test case 4: " + result4); // Expected output: 3
    }
}
