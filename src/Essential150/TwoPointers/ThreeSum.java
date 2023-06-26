package Essential150.TwoPointers;

/*

Problem    :   https://leetcode.com/problems/valid-palindrome/description/
Solutions  :   https://youtu.be/jJXJ16kPFWg
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Two Pointers                         |       O(n^2)    |       O(n)       |

The space complexity is determined by the space required to store the resulting triplets in the result list. 
In the worst case, the number of valid triplets can be O(n^2) when all elements in the array form unique triplets.
Hence, the space complexity is O(n).

*/

import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length < 3)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // after this point, it is not possible to find a triplet that sums up to zero.
            if (nums[i] > 0)
                break;
            // avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // avoid duplicates
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    // avoid duplicates
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;

                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();

        // Test case 1: Example case
        int[] nums1 = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result1 = solution.threeSum(nums1);
        System.out.println("Test case 1:");
        for (List<Integer> list : result1) {
            System.out.println(list);
        }

        // Test case 2: No valid triplets
        int[] nums2 = { 1, 2, 3, 4, 5 };
        List<List<Integer>> result2 = solution.threeSum(nums2);
        System.out.println("Test case 2:");
        for (List<Integer> list : result2) {
            System.out.println(list);
        }

        // Test case 3: All zeros
        int[] nums3 = { 0, 0, 0 };
        List<List<Integer>> result3 = solution.threeSum(nums3);
        System.out.println("Test case 3:");
        for (List<Integer> list : result3) {
            System.out.println(list);
        }
    }
}
