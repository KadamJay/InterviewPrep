package Essential150.Stack;

/*

Problem    :   https://leetcode.com/problems/daily-temperatures/
Solutions  :   https://youtu.be/cTBiBSnjO3c
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Stack                                |       O(n)      |       O(n)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | Brute Force                          |       O(n^2)    |       O(1)       |

Time complexity: O(1) for all operations (push, pop, top, getMin).
Space complexity: O(n), where n is the number of elements in the stack.
*/

import java.util.*;

class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            int currentTemp = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        DailyTemperature solution = new DailyTemperature();

        // Test case 1: Regular input with increasing temperatures
        int[] temperatures1 = { 30, 35, 40, 32, 38 };
        int[] result1 = solution.dailyTemperatures(temperatures1);
        System.out.println("Test case 1:");
        System.out.println(Arrays.toString(result1)); // Expected output: [1, 1, 0, 1, 0]

        // Test case 2: Regular input with decreasing temperatures
        int[] temperatures2 = { 40, 35, 30, 28, 20 };
        int[] result2 = solution.dailyTemperatures(temperatures2);
        System.out.println("Test case 2:");
        System.out.println(Arrays.toString(result2)); // Expected output: [0, 0, 0, 0, 0]

        // Test case 3: Regular input with fluctuating temperatures
        int[] temperatures3 = { 25, 30, 28, 35, 32 };
        int[] result3 = solution.dailyTemperatures(temperatures3);
        System.out.println("Test case 3:");
        System.out.println(Arrays.toString(result3)); // Expected output: [1, 0, 1, 0, 0]

        // Test case 4: Empty input array
        int[] temperatures4 = {};
        int[] result4 = solution.dailyTemperatures(temperatures4);
        System.out.println("Test case 4:");
        System.out.println(Arrays.toString(result4)); // Expected output: []

        // Test case 5: Input array with only one temperature
        int[] temperatures5 = { 30 };
        int[] result5 = solution.dailyTemperatures(temperatures5);
        System.out.println("Test case 5:");
        System.out.println(Arrays.toString(result5)); // Expected output: [0]
    }
}
