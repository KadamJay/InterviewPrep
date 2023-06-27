package Essential150.Stack;
/*

Problem    :   https://leetcode.com/problems/valid-parentheses/description/
Solutions  :   https://youtu.be/WTzjTskDFMg
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Stack                                |       O(n)      |       O(n)       |

*/

import java.util.*;

class ValidParanthesis {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || map.get(c) != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParanthesis solution = new ValidParanthesis();

        // Test case 1: Valid parentheses
        String input1 = "(([]))";
        boolean isValid1 = solution.isValid(input1);
        System.out.println("Test case 1: " + isValid1);

        // Test case 2: Invalid parentheses
        String input2 = "([)]";
        boolean isValid2 = solution.isValid(input2);
        System.out.println("Test case 2: " + isValid2);

        // Test case 3: Empty string
        String input3 = "";
        boolean isValid3 = solution.isValid(input3);
        System.out.println("Test case 3: " + isValid3);

        // Test case 4: Only opening parentheses
        String input4 = "({[";
        boolean isValid4 = solution.isValid(input4);
        System.out.println("Test case 4: " + isValid4);

        // Test case 5: Only closing parentheses
        String input5 = ")}]";
        boolean isValid5 = solution.isValid(input5);
        System.out.println("Test case 5: " + isValid5);

        // Test case 6: Mix of valid and invalid parentheses
        String input6 = "{([])}[()])";
        boolean isValid6 = solution.isValid(input6);
        System.out.println("Test case 6: " + isValid6);
    }
}
