package Essential150.Greedy;

/*
Problem    :   https://leetcode.com/problems/maximum-subarray/description/
Solutions  :   https://youtu.be/5WZl3MMT0Eg
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |         O(n)         |       O(1)       |

*/
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = 0;
            }

            curSum += nums[i];

            maxSum = Math.max(maxSum, curSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int result1 = maxSubArray(nums1);
        System.out.println(result1); // Expected: 6

        int[] nums2 = { 1, 2, -1, 3, 4, -1 };
        int result2 = maxSubArray(nums2);
        System.out.println(result2); // Expected: 9

        int[] nums3 = { -1, -2, -3, -4 };
        int result3 = maxSubArray(nums3);
        System.out.println(result3); // Expected: -1
    }
}
