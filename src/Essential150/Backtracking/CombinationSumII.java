package Essential150.Backtracking;

/*
Problem    :    https://leetcode.com/problems/combination-sum-ii/
Solutions  :    https://www.youtube.com/watch?v=dvZdWR0sHMk&list=PLzffTJx5aHaSJ4XaG55cI3Z0VrNOyLWpH&index=6&ab_channel=PrakashShukla
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Recursive                            |         O(n*2^n)     |       O(n*2^N)   |


CheatSheet: 
https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public static void main(String[] args) {
        // Test cases
        int[] candidates1 = { 10, 1, 2, 7, 6, 1, 5 };
        int target1 = 8;
        List<List<Integer>> combinations1 = combinationSum2(candidates1, target1);
        System.out.println("Combinations: " + combinations1);

        int[] candidates2 = { 2, 5, 2, 1, 2 };
        int target2 = 5;
        List<List<Integer>> combinations2 = combinationSum2(candidates2, target2);
        System.out.println("Combinations: " + combinations2);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(result, new ArrayList<>(), 0, target, candidates);
        return result;
    }

    private static void generateCombinations(List<List<Integer>> result, List<Integer> combination, int start,
            int target, int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i])
                continue;

            combination.add(candidates[i]);
            generateCombinations(result, combination, i + 1, target - candidates[i], candidates);
            combination.remove(combination.size() - 1);
        }
    }
}
