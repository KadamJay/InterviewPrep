package Essential150.Backtracking;

/*
Problem    :    https://leetcode.com/problems/permutations
Solutions  :    https://www.youtube.com/watch?v=H232aocj7bQ&ab_channel=NikhilLohia
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Recursive                            |         O(N!)        |       O(N!)      |

The time complexity of the permute method is O(N!), where N is the length of the nums array. This is because there are N! 
possible permutations for an array of length N.

The space complexity is O(N!), as well, because in the worst case, the output list of permutations can contain N! elements, 
each having N elements.

CheatSheet: 
https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/

*/

import java.util.ArrayList;
import java.util.List;

class Permutations {
    public static void main(String[] args) {
        // Test case
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> permutations = permute(nums);
        System.out.println("Permutations: " + permutations);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(result, new ArrayList<>(), nums);
        return result;
    }

    private static void generatePermutations(List<List<Integer>> result, List<Integer> permutation, int[] nums) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (permutation.contains(nums[i]))
                continue;
            permutation.add(nums[i]);
            generatePermutations(result, permutation, nums);
            permutation.remove(permutation.size() - 1);
        }
    }
}
