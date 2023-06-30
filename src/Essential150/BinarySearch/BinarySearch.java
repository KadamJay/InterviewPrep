package Essential150.BinarySearch;

/*

Problem    :   https://leetcode.com/problems/binary-search/description/
Solutions  :   https://youtu.be/s4DPM8ct1pI
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | BinarySearch                         |     O(log n)    |       O(1)       |

To avoid overflow, use this
int mid = left+ ((right-left)/2);

(right-left) is the distance between 2 indices, we are halviing it and adding it 
to left index, this will never overflow

*/
class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();

        // Test case 1: Target found in the middle
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int target1 = 3;
        int result1 = solution.search(nums1, target1);
        System.out.println("Test case 1:");
        System.out.println(result1); // Expected output: 2

        // Test case 2: Target found at the beginning
        int[] nums2 = { 1, 2, 3, 4, 5 };
        int target2 = 1;
        int result2 = solution.search(nums2, target2);
        System.out.println("Test case 2:");
        System.out.println(result2); // Expected output: 0

        // Test case 3: Target found at the end
        int[] nums3 = { 1, 2, 3, 4, 5 };
        int target3 = 5;
        int result3 = solution.search(nums3, target3);
        System.out.println("Test case 3:");
        System.out.println(result3); // Expected output: 4

        // Test case 4: Target not found
        int[] nums4 = { 1, 2, 3, 4, 5 };
        int target4 = 6;
        int result4 = solution.search(nums4, target4);
        System.out.println("Test case 4:");
        System.out.println(result4); // Expected output: -1

        // Test case 5: Empty array
        int[] nums5 = {};
        int target5 = 5;
        int result5 = solution.search(nums5, target5);
        System.out.println("Test case 5:");
        System.out.println(result5); // Expected output: -1
    }
}
