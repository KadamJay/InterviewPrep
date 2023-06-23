package Essential150.Arrays;

/*
Problem    :   https://leetcode.com/problems/longest-consecutive-sequence/
Solutions  :   https://www.youtube.com/watch?v=P6RZZMu_maU
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Set                                  |      O(n)            |       O(n)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Sorting                              |      O(nLogn)        |       O(1)       |

- Iterate over each number in the input array.
- Check if the current number minus 1 is not present in the set. If so, it indicates the starting point of a sequence.
- If it's the starting point of a sequence, continue checking for the consecutive numbers by incrementing 
    len until the next number is present in the set.
- Update the maxSeqLen 
 */
import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxSeqLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + len)) {
                    len++;
                }
                maxSeqLen = Math.max(len, maxSeqLen);
            }
        }

        return maxSeqLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();

        // Test case 1: No numbers
        int[] nums1 = {};
        int result1 = solution.longestConsecutive(nums1);
        System.out.println(result1); // Expected output: 0

        // Test case 2: Single number
        int[] nums2 = { 5 };
        int result2 = solution.longestConsecutive(nums2);
        System.out.println(result2); // Expected output: 1

        // Test case 3: Consecutive numbers with gaps
        int[] nums3 = { 100, 4, 200, 1, 3, 2, 5 };
        int result3 = solution.longestConsecutive(nums3);
        System.out.println(result3); // Expected output: 5

        // Test case 4: All duplicates
        int[] nums4 = { 2, 2, 2, 2, 2 };
        int result4 = solution.longestConsecutive(nums4);
        System.out.println(result4); // Expected output: 1

        // Test case 5: Negative numbers
        int[] nums5 = { -3, -2, -1, 0, 1, 2, 3 };
        int result5 = solution.longestConsecutive(nums5);
        System.out.println(result5); // Expected output: 7
    }
}
