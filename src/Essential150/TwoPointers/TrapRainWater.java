package Essential150.TwoPointers;

/*

Problem    :   https://leetcode.com/problems/trapping-rain-water/
Solutions  :   https://youtu.be/ZI2z5pq0TqA
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Two Pointers                         |        O(n)     |       O(1)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | Auxiliary Array                      |        O(n)     |       O(n)       |


*/
public class TrapRainWater {
    public int trapWithArray(int[] height) {
        int len = height.length;

        // Calculate the maximum height on the left side of each element
        int[] leftMax = new int[len];
        int maxOnLeft = 0;
        for (int i = 0; i < len; i++) {
            leftMax[i] = maxOnLeft;
            maxOnLeft = Math.max(maxOnLeft, height[i]);
        }

        // Calculate the maximum height on the right side of each element
        int[] rightMax = new int[len];
        int maxOnRight = 0;
        for (int i = len - 1; i >= 0; i--) {
            rightMax[i] = maxOnRight;
            maxOnRight = Math.max(maxOnRight, height[i]);
        }

        int waterVolume = 0;

        // Calculate the trapped water volume at each position
        for (int i = 0; i < len; i++) {
            int minHeight = Math.min(rightMax[i], leftMax[i]);
            waterVolume += Math.max(0, minHeight - height[i]);
        }

        return waterVolume;
    }

    public int trapTwoPointer(int[] height) {
        int len = height.length;

        int left = 0, right = len - 1;
        int leftMax = height[0], rightMax = height[len - 1];
        int waterQty = 0;

        // Use two pointers to find the trapped water volume
        while (left < right) {
            if (leftMax <= rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                waterQty += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                waterQty += rightMax - height[right];
            }
        }

        return waterQty;
    }

    public static void main(String[] args) {
        // Test Cases
        TrapRainWater trapRainWater = new TrapRainWater();

        int[] heights1 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result1 = trapRainWater.trapWithArray(heights1);
        System.out.println("Trap Volume (with array): " + result1);

        int[] heights2 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result2 = trapRainWater.trapTwoPointer(heights2);
        System.out.println("Trap Volume (two pointer): " + result2);
    }
}
