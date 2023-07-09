package Essential150.Greedy;

/*
Problem    :    https://leetcode.com/problems/jump-game
Solutions  :    https://youtu.be/Yan0cv2cLy8
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |         O(n)         |       O(1)       |

The key idea is that if we can reach a certain index, then all the previous indices must also be reachable.
By keeping track of the furthest reachable index, we can determine if the last index is reachable by the end 
of the loop.

*/

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxReachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable) {
                return false;
            }
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = { 2, 3, 1, 1, 4 };
        boolean result1 = canJump(nums1);
        System.out.println(result1); // Expected: true

        int[] nums2 = { 3, 2, 1, 0, 4 };
        boolean result2 = canJump(nums2);
        System.out.println(result2); // Expected: false

        int[] nums3 = { 0 };
        boolean result3 = canJump(nums3);
        System.out.println(result3); // Expected: true
    }
}
