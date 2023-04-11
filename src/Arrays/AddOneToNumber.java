package Arrays;

/**
 * @author jakadam on 2020-01-05
 */

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 *
 * the returned vector should be [1, 2, 4]
 *
 * as 123 + 1 = 124.
 *
 * NOTE: Certain things are intentionally left unclear in this question which
 * you should
 * practice asking the interviewer.
 * For example, for this problem, following are some good questions to ask :
 * Q : Can the input have 0’s before the most significant digit. Or in other
 * words,
 * is 0 1 2 3 a valid input?
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other
 * words,
 * is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before
 * the most
 * significant digit.
 */

public class AddOneToNumber {
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                // digits[i] has to be 9 in this condition, set the numbers to 0 till they are 9
                digits[i] = 0;
            }
        }

        // if control reaches here, means array was of the for 999 and return should be
        // 10000
        // copy contents of input array and prepend 1
        int[] ans = new int[len + 1];
        ans[0] = 1;
        for (int i = 1; i < ans.length - 1; i++) {
            ans[i] = digits[i];
        }

        return ans;
    }

}
