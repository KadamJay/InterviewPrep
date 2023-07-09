package Essential150.Greedy;

/*
Problem    :    https://leetcode.com/problems/jump-game-ii
Solutions  :    https://www.youtube.com/watch?v=a9r98S-pDvk
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |         O(n)         |       O(1)       |


*/
public class JumpGameII {

    public static int jump(int[] nums) {
        int curJumpEnd = 0;
        int maxReachable = 0;
        int jumpCount = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (curJumpEnd == i) {
                jumpCount++;
                curJumpEnd = maxReachable;
            }
        }

        return jumpCount;
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = { 2, 3, 1, 1, 4 }; // Minimum jumps: 2
        int[] nums2 = { 1, 1, 1, 1, 1 }; // Minimum jumps: 4
        int[] nums3 = { 1, 2, 3, 4, 5 }; // Minimum jumps: 3
        int[] nums4 = { 3, 2, 1, 0, 4 }; // Minimum jumps: 2

        System.out.println("Minimum number of jumps (nums1): " + jump(nums1));
        System.out.println("Minimum number of jumps (nums2): " + jump(nums2));
        System.out.println("Minimum number of jumps (nums3): " + jump(nums3));
        System.out.println("Minimum number of jumps (nums4): " + jump(nums4));
    }
}
