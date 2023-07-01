package Essential150.DynamicProgramming;

/*

Problem    :   https://leetcode.com/problems/house-robber/
Solutions  :   https://youtu.be/73r3KWiEvyk
Approaches :


| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Recursion                            |      O(n)       |       O(1)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | DP [Bottom Up]                       |      O(n)       |       O(n)       |

*/

class HouseRobberI {
    public int rob(int[] nums) {
        int len = nums.length;

        int robExcludingPrev = 0;
        int robIncludingPrev = 0;

        for (int i = 0; i < len; i++) {
            int temp = Math.max(robExcludingPrev + nums[i], robIncludingPrev);
            robExcludingPrev = robIncludingPrev;
            robIncludingPrev = temp;
        }

        return robIncludingPrev;
    }

    public int robDP(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];

        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        HouseRobberI solution = new HouseRobberI();

        // Test rob method
        int[] nums1 = { 1, 2, 3, 1 };
        System.out.println(solution.rob(nums1)); // Output: 4

        int[] nums2 = { 2, 7, 9, 3, 1 };
        System.out.println(solution.rob(nums2)); // Output: 12

        // Test robDP method
        int[] nums3 = { 1, 2, 3, 1 };
        System.out.println(solution.robDP(nums3)); // Output: 4

        int[] nums4 = { 2, 7, 9, 3, 1 };
        System.out.println(solution.robDP(nums4)); // Output: 12
    }
}
