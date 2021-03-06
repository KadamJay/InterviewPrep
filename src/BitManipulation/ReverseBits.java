package BitManipulation;

/**
 * @author jakadam on 2020-01-08
 */

/**
 * Reverse the bits of an 32 bit unsigned integer A.
 *
 * Input Format:
 *
 *     First and only argument of input contains an integer A
 * Output Format:
 *
 *     return a single unsigned integer denoting minimum xor value
 * Constraints:
 *
 * 0 <= A < 2^32
 * For Examples :
 *
 * Example Input 1:
 *     A = 0
 * Example Output 1:
 *     0
 * Explanation 1:
 *         00000000000000000000000000000000
 * =>      00000000000000000000000000000000
 * Example Input 2:
 *     A = 3
 * Example Output 2:
 *     3221225472
 * Explanation 2:
 *           00000000000000000000000000000011
 * =>        11000000000000000000000000000000
 * Since java does not have unsigned int, use long
 */

public class ReverseBits {
    public long reverse(long A) {
        long B = 0; //B will hold the reversed number
        for(int i=0;i<32;i++){  //Iterating on all bit positions
            long k = A & 1;      //Extracting the rightmost bit from A (the ith bit in original number)
            B <<= 1;            //Shifting B to left (rightmost bit becomes 0)
            B |= k;             //Adding the extracted bit
            A >>= 1;            //Now the (i+1)st bit shifts to the rightmost position in A
        }
        return B;
    }
}

/**
 *https://www.interviewbit.com/problems/reverse-bits/
 */