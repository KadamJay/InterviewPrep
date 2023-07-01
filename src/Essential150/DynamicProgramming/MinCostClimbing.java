package Essential150.DynamicProgramming;

/*

Problem    :   https://leetcode.com/problems/min-cost-climbing-stairs/
Solutions  :   https://youtu.be/ktmzAZWkEZ0
Approaches :


| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | DP [Top Down]                        |    O(n)         |       O(1)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | DP [Top Down Extra Mem]              |    O(n)         |       O(n)       |


*/
class MinCostClimbing {

    public int minCostClimbingStairsExtraMemmory(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        // 10 15 20 0
        minCost[minCost.length - 1] = 0;
        minCost[minCost.length - 2] = cost[cost.length - 1];

        for (int i = minCost.length - 3; i >= 0; i--) {
            minCost[i] = Math.min(minCost[i + 1], minCost[i + 2]) + cost[i];
        }
        return Math.min(minCost[0], minCost[1]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
        // Test cases
        int[] cost1 = { 10, 15, 20 };
        int result1 = new MinCostClimbing().minCostClimbingStairs(cost1);
        System.out.println("Minimum cost for test case 1: " + result1);

        int[] cost2 = { 1, 1 };
        int result2 = new MinCostClimbing().minCostClimbingStairs(cost2);
        System.out.println("Minimum cost for test case 2: " + result2);

        int[] cost3 = { 0, 0, 0, 0 };
        int result3 = new MinCostClimbing().minCostClimbingStairs(cost3);
        System.out.println("Minimum cost for test case 3: " + result3);

        int[] cost4 = { 10 };
        int result4 = new MinCostClimbing().minCostClimbingStairs(cost4);
        System.out.println("Minimum cost for test case 4: " + result4);
    }
}
