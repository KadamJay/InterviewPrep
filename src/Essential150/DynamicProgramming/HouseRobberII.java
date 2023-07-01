package Essential150.DynamicProgramming;

/*

Problem    :   https://leetcode.com/problems/house-robber-ii/
Solutions  :   https://youtu.be/rWAJCfYYOvM
Approaches :


| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | DP [Bottom Up]                       |      O(n)       |       O(1)       |

*/

class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // Calculate the maximum amount by considering two cases:
        // 1. Rob the first house and skip the last house
        // 2. Rob the last house and skip the first house
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    // Helper function to calculate the maximum amount from a range of houses
    private int robHelper(int[] nums, int start, int end) {
        int robExcludingPrev = 0;
        int robIncludingPrev = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(robExcludingPrev + nums[i], robIncludingPrev);
            robExcludingPrev = robIncludingPrev;
            robIncludingPrev = temp;
        }

        return robIncludingPrev;
    }

    // Unit tests
    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();

        // Test case 1: nums = [2,3,2], expected output = 3
        int[] nums1 = { 2, 3, 2 };
        int result1 = solution.rob(nums1);
        System.out.println(result1 == 3 ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: nums = [1,2,3,1], expected output = 4
        int[] nums2 = { 1, 2, 3, 1 };
        int result2 = solution.rob(nums2);
        System.out.println(result2 == 4 ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3: nums = [0], expected output = 0
        int[] nums3 = { 0 };
        int result3 = solution.rob(nums3);
        System.out.println(result3 == 0 ? "Test case 3 passed" : "Test case 3 failed");
    }
}
