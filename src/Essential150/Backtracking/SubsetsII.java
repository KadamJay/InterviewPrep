package Essential150.Backtracking;

/*
Problem    :    https://leetcode.com/problems/subsets-ii/description/
Solutions  :    https://www.youtube.com/watch?v=Izkce7hta5U&list=PLzffTJx5aHaSJ4XaG55cI3Z0VrNOyLWpH&index=4&pp=iAQB
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |         O(n*2^n)     |       O(n*2^N)   |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Recursive                            |         O(n*2^n)     |       O(n*2^N)   |

Space Complexity: O(2^N) - Since there are 2^N subsets for an array of size N, the space 
complexity is exponential.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(result, new ArrayList<>(), 0, nums);
        return result;
    }

    private static void generateSubsets(List<List<Integer>> result, List<Integer> subset, int start, int[] nums) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1])
                continue;

            subset.add(nums[i]);
            generateSubsets(result, subset, i + 1, nums);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = { 1, 2, 2 };
        int[] nums2 = { 0 };
        int[] nums3 = { 1, 1, 2, 2 };

        List<List<Integer>> subsets1 = subsetsWithDup(nums1);
        System.out.println("Subsets with duplicates: " + subsets1);

        List<List<Integer>> subsets2 = subsetsWithDup(nums2);
        System.out.println("Subsets with duplicates: " + subsets2);

        List<List<Integer>> subsets3 = subsetsWithDup(nums3);
        System.out.println("Subsets with duplicates: " + subsets3);
    }

}
