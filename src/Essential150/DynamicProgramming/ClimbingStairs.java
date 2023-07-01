package Essential150.DynamicProgramming;

/*

Problem    :   https://leetcode.com/problems/climbing-stairs/description/
Solutions  :   https://www.youtube.com/watch?v=Y0lT9Fck7qI&ab_channel=NeetCode
Approaches :


| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Recursion                            |    O(2^n)       |       O(n)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | DP [Top Down]                        |    O(n)         |       O(n)       |
|-----|--------------------------------------|-----------------|------------------|
|  3  | DP [Bottom Up]                       |    O(n)         |       O(n)       |
|-----|--------------------------------------|-----------------|------------------|
|  4  | Fibbonachi Sequence                  |    O(n)         |       O(1)       |

*/
import java.util.Arrays;

class ClimbingStairs {
    // Approach 1: Recursion
    public int climbStairsRecursion(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }

    // Approach 2: Dynamic Programming (Top-Down)
    public int climbStairsTopDown(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsTopDownMemo(n, memo);
    }

    private int climbStairsTopDownMemo(int n, int[] memo) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (memo[n] != -1)
            return memo[n];

        int ways = climbStairsTopDownMemo(n - 1, memo) + climbStairsTopDownMemo(n - 2, memo);
        memo[n] = ways;
        return ways;
    }

    // Approach 3: Dynamic Programming (Bottom-Up)
    public int climbStairsBottomUp(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Approach 4: Fibonacci Sequence
    public int climbStairsFibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int prevPrev = 1;
        int prev = 2;
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return current;
    }

    // Unit Test Cases
    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();

        // Test cases for Approach 1: Recursion
        System.out.println(cs.climbStairsRecursion(1)); // Expected: 1
        System.out.println(cs.climbStairsRecursion(2)); // Expected: 2
        System.out.println(cs.climbStairsRecursion(3)); // Expected: 3
        System.out.println(cs.climbStairsRecursion(4)); // Expected: 5
        System.out.println(cs.climbStairsRecursion(5)); // Expected: 8
        System.out.println(cs.climbStairsRecursion(6)); // Expected: 13

        // Test cases for Approach 2: Dynamic Programming (Top-Down)
        System.out.println(cs.climbStairsTopDown(1)); // Expected: 1
        System.out.println(cs.climbStairsTopDown(2)); // Expected: 2
        System.out.println(cs.climbStairsTopDown(3)); // Expected: 3
        System.out.println(cs.climbStairsTopDown(4)); // Expected: 5
        System.out.println(cs.climbStairsTopDown(5)); // Expected: 8
        System.out.println(cs.climbStairsTopDown(6)); // Expected: 13

        // Test cases for Approach 3: Dynamic Programming (Bottom-Up)
        System.out.println(cs.climbStairsBottomUp(1)); // Expected: 1
        System.out.println(cs.climbStairsBottomUp(2)); // Expected: 2
        System.out.println(cs.climbStairsBottomUp(3)); // Expected: 3
        System.out.println(cs.climbStairsBottomUp(4)); // Expected: 5
        System.out.println(cs.climbStairsBottomUp(5)); // Expected: 8
        System.out.println(cs.climbStairsBottomUp(6)); // Expected: 13

        // Test cases for Approach 4: Fibonacci Sequence
        System.out.println(cs.climbStairsFibonacci(1)); // Expected: 1
        System.out.println(cs.climbStairsFibonacci(2)); // Expected: 2
        System.out.println(cs.climbStairsFibonacci(3)); // Expected: 3
        System.out.println(cs.climbStairsFibonacci(4)); // Expected: 5
        System.out.println(cs.climbStairsFibonacci(5)); // Expected: 8
        System.out.println(cs.climbStairsFibonacci(6)); // Expected: 13
    }
}
