package Essential150.Backtracking;

/*
Problem    :    https://leetcode.com/problems/combination-sum/
Solutions  :    https://www.youtube.com/watch?v=obBSF4AG3qU&list=PLzffTJx5aHaSJ4XaG55cI3Z0VrNOyLWpH&index=5&ab_channel=PrakashShukla
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Recursive                            |         O(n*2^n)     |       O(n*2^N)   |


CheatSheet: 
https://leetcode.com/problems/subsets/solutions/27281/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/

*/

import java.util.ArrayList;
import java.util.List;

class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            generateCombinations(result, combination, i, target - candidates[i], candidates);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] candidates1 = { 2, 3, 6, 7 };
        int target1 = 7;
        List<List<Integer>> combinations1 = combinationSum(candidates1, target1);
        System.out.println("Combinations: " + combinations1);

        int[] candidates2 = { 2, 3, 5 };
        int target2 = 8;
        List<List<Integer>> combinations2 = combinationSum(candidates2, target2);
        System.out.println("Combinations: " + combinations2);
    }

}
