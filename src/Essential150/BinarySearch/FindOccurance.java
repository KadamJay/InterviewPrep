package Essential150.BinarySearch;

/*

Problem    :   https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | BinarySearch                         |     O(log n)    |       O(1)       |

*/
import java.util.Arrays;

class FindOccurance {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = findOccurrence(nums, target, true);
        int lastOccurrence = findOccurrence(nums, target, false);

        return new int[] { firstOccurrence, lastOccurrence };
    }

    private int findOccurrence(int[] nums, int target, boolean isFirstOccurrence) {
        int left = 0;
        int right = nums.length - 1;
        int occurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                occurrence = mid;

                if (isFirstOccurrence) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return occurrence;
    }

    public static void main(String[] args) {
        FindOccurance solution = new FindOccurance();

        // Test case 1: Target found multiple times
        int[] nums1 = { 1, 2, 2, 3, 4, 4, 4, 5 };
        int target1 = 4;
        int[] result1 = solution.searchRange(nums1, target1);
        System.out.println(Arrays.toString(result1)); // Expected output: [4, 6]

        // Test case 2: Target not found
        int[] nums2 = { 1, 2, 3, 5, 6 };
        int target2 = 4;
        int[] result2 = solution.searchRange(nums2, target2);
        System.out.println(Arrays.toString(result2)); // Expected output: [-1, -1]

        // Test case 3: Target found at the beginning and end
        int[] nums3 = { 2, 2, 2, 2, 2 };
        int target3 = 2;
        int[] result3 = solution.searchRange(nums3, target3);
        System.out.println(Arrays.toString(result3)); // Expected output: [0, 4]

        // Test case 4: Empty array
        int[] nums4 = {};
        int target4 = 3;
        int[] result4 = solution.searchRange(nums4, target4);
        System.out.println(Arrays.toString(result4)); // Expected output: [-1, -1]

        // Test case 5: Single element array with target
        int[] nums5 = { 5 };
        int target5 = 5;
        int[] result5 = solution.searchRange(nums5, target5);
        System.out.println(Arrays.toString(result5)); // Expected output: [0, 0]
    }

}
