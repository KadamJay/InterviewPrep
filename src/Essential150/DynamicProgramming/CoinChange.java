package Essential150.DynamicProgramming;

/*

Problem    :   https://leetcode.com/problems/coin-change/
Solutions  :   https://youtu.be/H9bfqozjoqs
Approaches :


| No. | Approach                             | Time Complexity              | Space Complexity |
|-----|--------------------------------------|------------------------------|------------------|
|  1  | DP [Bottom Up]                       | O(targetAmount * numCoins)   | O(targetAmount)  |

*/

import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int targetAmount) {
        if (targetAmount < 0 || coins == null || coins.length == 0) {
            return -1;
        }

        int[] dp = new int[targetAmount + 1];
        Arrays.fill(dp, targetAmount + 1);
        dp[0] = 0;

        for (int amount = 1; amount <= targetAmount; amount++) {
            for (int coin : coins) {
                if (amount - coin >= 0) {
                    dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
                }
            }
        }

        return dp[targetAmount] == targetAmount + 1 ? -1 : dp[targetAmount];
    }

    // Unit tests
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();

        // Test case 1: coins = [1, 2, 5], targetAmount = 11, expected output = 3
        int[] coins1 = { 1, 2, 5 };
        int targetAmount1 = 11;
        int result1 = solution.coinChange(coins1, targetAmount1);
        System.out.println(result1 == 3 ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: coins = [2], targetAmount = 3, expected output = -1
        int[] coins2 = { 2 };
        int targetAmount2 = 3;
        int result2 = solution.coinChange(coins2, targetAmount2);
        System.out.println(result2 == -1 ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3: coins = [1, 5, 10, 25], targetAmount = 30, expected output = 2
        int[] coins3 = { 1, 5, 10, 25 };
        int targetAmount3 = 30;
        int result3 = solution.coinChange(coins3, targetAmount3);
        System.out.println(result3 == 2 ? "Test case 3 passed" : "Test case 3 failed");
    }
}
