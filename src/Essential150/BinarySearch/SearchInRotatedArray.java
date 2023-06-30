package Essential150.BinarySearch;

/*

Problem    :   https://leetcode.com/problems/search-in-rotated-sorted-array/description/
Solutions  :   https://youtu.be/U8XENwh8Oy8
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | BinarySearch                         |     O(log n)    |       O(1)       |

*/

class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target) // Found the target value
                return mid;
            else if (nums[left] <= nums[mid]) { // Left subarray is sorted
                if (target >= nums[left] && target < nums[mid]) { // Target is in the left subarray
                    right = mid - 1;
                } else { // Target is in the right subarray
                    left = mid + 1;
                }
            } else if (nums[mid] <= nums[right]) { // Right subarray is sorted
                if (target > nums[mid] && target <= nums[right]) { // Target is in the right subarray
                    left = mid + 1;
                } else { // Target is in the left subarray
                    right = mid - 1;
                }
            }
        }

        return -1; // Target value not found
    }

    public static void main(String[] args) {
        SearchInRotatedArray solution = new SearchInRotatedArray();

        // Test cases
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int target1 = 0;
        int expected1 = 4;
        int result1 = solution.search(nums1, target1);
        System.out.println(result1 == expected1 ? "Test case 1 passed" : "Test case 1 failed");

        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int target2 = 3;
        int expected2 = -1;
        int result2 = solution.search(nums2, target2);
        System.out.println(result2 == expected2 ? "Test case 2 passed" : "Test case 2 failed");

        int[] nums3 = { 1 };
        int target3 = 1;
        int expected3 = 0;
        int result3 = solution.search(nums3, target3);
        System.out.println(result3 == expected3 ? "Test case 3 passed" : "Test case 3 failed");

        int[] nums4 = { 1, 3 };
        int target4 = 3;
        int expected4 = 1;
        int result4 = solution.search(nums4, target4);
        System.out.println(result4 == expected4 ? "Test case 4 passed" : "Test case 4 failed");

        int[] nums5 = { 3, 1 };
        int target5 = 1;
        int expected5 = 1;
        int result5 = solution.search(nums5, target5);
        System.out.println(result5 == expected5 ? "Test case 5 passed" : "Test case 5 failed");
    }

}
