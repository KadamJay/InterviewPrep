package Essential150.TwoPointers;

/*

Problem    :   https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Solutions  :   https://youtu.be/cQ1Oz4ckceM
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Two Pointers                         |       O(n )     |       O(1)       |

*/

class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] { left + 1, right + 1 };
    }

    public static void main(String[] args) {
        TwoSumSorted solution = new TwoSumSorted();

        // Test case 1: Target is present in the middle
        int[] numbers1 = { 2, 4, 6, 7, 9 };
        int target1 = 10;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Test case 1: " + result1[0] + ", " + result1[1]); // Output: 1, 3

        // Test case 2: Target is the smallest number in the array
        int[] numbers2 = { -1, 0, 2, 4, 6 };
        int target2 = -1;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Test case 2: " + result2[0] + ", " + result2[1]); // Output: 1, 2

        // Test case 3: Target is the largest number in the array
        int[] numbers3 = { 1, 3, 5, 7, 9 };
        int target3 = 9;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("Test case 3: " + result3[0] + ", " + result3[1]); // Output: 1, 5
    }
}
