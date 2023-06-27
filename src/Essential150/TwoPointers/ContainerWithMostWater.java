package Essential150.TwoPointers;

/*

Problem    :   https://leetcode.com/problems/container-with-most-water/description/
Solutions  :   https://youtu.be/UuiTKBwPgAo
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Brute Force                          |       O(n^2)    |       O(n)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | Two Pointers                         |       O(n)      |       O(1)       |

The space complexity is determined by the space required to store the resulting triplets in the result list. 
In the worst case, the number of valid triplets can be O(n^2) when all elements in the array form unique triplets.
Hence, the space complexity is O(n).

*/

class ContainerWithMostWater {
    public int maxAreaTwoPointers(int[] heightArray) {
        int length = heightArray.length;
        int maxArea = Integer.MIN_VALUE;

        int left = 0;
        int right = length - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heightArray[right], heightArray[left]);
            int area = width * height;
            maxArea = Math.max(maxArea, area);

            if (heightArray[right] < heightArray[left])
                right--;
            else if (heightArray[right] >= heightArray[left])
                left++;
        }

        return maxArea;
    }

    public int maxAreaBruteForce(int[] heightArray) {
        int length = heightArray.length;
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int width = j - i;
                int height = Math.min(heightArray[j], heightArray[i]);
                int area = width * height;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();

        // Test case 1: Standard case
        int[] heights1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int result1 = solution.maxAreaTwoPointers(heights1);
        System.out.println("Test case 1: maxAreaTwoPointers " + result1); // Expected output: 49
        result1 = solution.maxAreaTwoPointers(heights1);
        System.out.println("Test case 1: maxAreaBruteForce " + result1); // Expected output: 49

        // Test case 2: Array with decreasing heights
        int[] heights2 = { 7, 6, 5, 4, 3, 2, 1 };
        int result2 = solution.maxAreaTwoPointers(heights2);
        System.out.println("Test case 2: maxAreaTwoPointers " + result2); // Expected output: 9
        result2 = solution.maxAreaTwoPointers(heights2);
        System.out.println("Test case 2: maxAreaBruteForce " + result2); // Expected output: 9

        // Test case 3: Array with increasing heights
        int[] heights3 = { 1, 2, 3, 4, 5, 6, 7 };
        int result3 = solution.maxAreaTwoPointers(heights3);
        System.out.println("Test case 3: maxAreaTwoPointers " + result3); // Expected output: 12
        result3 = solution.maxAreaTwoPointers(heights3);
        System.out.println("Test case 3: maxAreaBruteForce " + result3); // Expected output: 12

        // Test case 4: Array with equal heights
        int[] heights4 = { 5, 5, 5, 5, 5 };
        int result4 = solution.maxAreaTwoPointers(heights4);
        System.out.println("Test case 4: maxAreaTwoPointers " + result4); // Expected output: 20
        result4 = solution.maxAreaTwoPointers(heights4);
        System.out.println("Test case 4: maxAreaBruteForce " + result4); // Expected output: 20

        // Test case 5: Array with only two elements
        int[] heights5 = { 2, 5 };
        int result5 = solution.maxAreaTwoPointers(heights5);
        System.out.println("Test case 5: maxAreaTwoPointers" + result5); // Expected output: 2
        result5 = solution.maxAreaTwoPointers(heights5);
        System.out.println("Test case 5: maxAreaBruteForce" + result5); // Expected output: 2
    }
}
