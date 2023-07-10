package Essential150.Backtracking;

/*
Problem    :    https://leetcode.com/problems/subsets/description/
Solutions  :    https://www.youtube.com/watch?v=kYY9DotIKlo
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
import java.util.List;

class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int len = result.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new ArrayList<>(result.get(j));
                temp.add(num);
                result.add(new ArrayList<>(temp));
            }
        }

        return result;
    }

    public static List<List<Integer>> subsetsRecursive(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(result, new ArrayList<>(), 0, nums);
        return result;
    }

    public static void generateSubsets(List<List<Integer>> result, List<Integer> temp, int start, int[] nums) {
        result.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            generateSubsets(result, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Test case 1: Empty array
        int[] nums1 = {};
        List<List<Integer>> subsets1 = subsets(nums1);
        List<List<Integer>> subsets1Recursive = subsetsRecursive(nums1);
        System.out.println(subsets1); // [[]]
        System.out.println(subsets1Recursive); // [[]]

        // Test case 2: Array with one element
        int[] nums2 = { 1 };
        List<List<Integer>> subsets2 = subsets(nums2);
        List<List<Integer>> subsets2Recursive = subsetsRecursive(nums2);
        System.out.println(subsets2); // [[] [1]]
        System.out.println(subsets2Recursive); // [[] [1]]

        // Test case 3: Array with multiple elements
        int[] nums3 = { 1, 2, 3 };
        List<List<Integer>> subsets3 = subsets(nums3);
        List<List<Integer>> subsets3Recursive = subsetsRecursive(nums3);
        System.out.println(subsets3); // [[] [1] [2] [1, 2] [3] [1, 3] [2, 3] [1, 2, 3]]
        System.out.println(subsets3Recursive); // [[] [1] [1, 2] [1, 2, 3] [1, 3] [2] [2, 3] [3]]
    }
}
