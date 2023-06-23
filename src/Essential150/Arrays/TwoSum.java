package Essential150.Arrays;

/*
Problem    :   https://leetcode.com/problems/two-sum/description/
Solutions  :   https://youtu.be/KLlXCFG5TnA
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Compare each element with every other|      O(n^2)     |       O(1)       |
|     | element using nested loops           |                 |                  |
|-----|--------------------------------------|-----------------|------------------|
|  2  | Map<Num, Index>                      |       O(n)      |       O(n)       |


*/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return ans;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        // Test cases
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = twoSum.twoSum(nums1, target1);
        System.out.println(Arrays.toString(result1)); // [0, 1]

        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = twoSum.twoSum(nums2, target2);
        System.out.println(Arrays.toString(result2)); // [1, 2]

        int[] nums3 = { 3, 3 };
        int target3 = 6;
        int[] result3 = twoSum.twoSum(nums3, target3);
        System.out.println(Arrays.toString(result3)); // [0, 1]

        int[] nums4 = { -1, -2, -3, -4, -5 };
        int target4 = -8;
        int[] result4 = twoSum.twoSum(nums4, target4);
        System.out.println(Arrays.toString(result4)); // [2, 4]

        int[] nums5 = { 0, 1, 2, 3, 4 };
        int target5 = 9;
        int[] result5 = twoSum.twoSum(nums5, target5);
        System.out.println(Arrays.toString(result5)); // [3, 4]
    }
}
