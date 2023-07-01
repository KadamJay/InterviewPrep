package DynamicProgramming.Classic;

/**
 * @author jakadam on 2019-12-24
 */

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * You are given coins of different denominations and a total amount of money
 * amount.
 * Write a function to compute the fewest number of coins that you need to make
 * up that amount.
 * If that amount of money cannot be made up by any combination of the coins,
 * return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */

class CoinChange {
    public static void main(String args[]) {
        CoinChangeSolver solver = new CoinChangeSolver();
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(solver.changeLinear(amount, coins));
    }
}

class CoinChangeSolver {
    public static int changeRec(int coins[], int totalAmount) {
        if (totalAmount == 0)
            return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= totalAmount) {
                int resForRemSum = changeRec(coins, totalAmount - coins[i]);
                if (resForRemSum != Integer.MAX_VALUE && resForRemSum + 1 < res)
                    res = resForRemSum + 1;
            }
        }
        return res;
    }

    public int changeLinear(int totalAmount, int[] coins) {
        int dp[] = new int[totalAmount + 1];
        dp[0] = 0;
        for (int i = 1; i <= totalAmount; i++)
            dp[i] = Integer.MAX_VALUE;
        for (int amount = 1; amount <= totalAmount; amount++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amount) {
                    int resForRemSum = dp[amount - coins[j]];
                    if (resForRemSum != Integer.MAX_VALUE && resForRemSum + 1 < dp[amount])
                        dp[amount] = resForRemSum + 1;
                }
            }
        }
        return dp[totalAmount];
    }
}

/**
 * https://leetcode.com/problems/coin-change/
 * https://www.youtube.com/watch?v=jgiZlGzXMBw
 */