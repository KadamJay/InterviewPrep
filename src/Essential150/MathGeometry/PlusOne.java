package Essential150.MathGeometry;

import java.util.Arrays;

/*

Problem    :   https://leetcode.com/problems/plus-one/
Solutions  :   https://youtu.be/jIaA8boiG1s
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Arithmatic                           |       O(n)      |       O(n)       |

The space complexity is O(n) as well. In the worst case, when the carry propagates to 
the most significant digit, the method creates a new array of length n + 1 to accommodate 
the additional digit.
*/

class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] ans = new int[len + 1];
        ans[0] = 1;
        for (int i = 1; i < ans.length - 1; i++) {
            ans[i] = digits[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();

        // Test Case 1: [1, 2, 4]
        int[] digits1 = { 1, 2, 3 };
        int[] result1 = plusOne.plusOne(digits1);
        System.out.println("plusOne([1, 2, 3]): " + Arrays.toString(result1));

        // Test Case 2: [4, 3, 2, 2]
        int[] digits2 = { 4, 3, 2, 1 };
        int[] result2 = plusOne.plusOne(digits2);
        System.out.println("plusOne([4, 3, 2, 1]): " + Arrays.toString(result2));

        // Test Case 3: [1, 0, 0, 0]
        int[] digits3 = { 9, 9, 9 };
        int[] result3 = plusOne.plusOne(digits3);
        System.out.println("plusOne([9, 9, 9]): " + Arrays.toString(result3));
    }
}
