package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author jakadam on 2020-01-06
 */

/**
 * Given an integer array, find if an integer p exists in the array such that
 * the number of
 * integers greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.
 * 
 * Input 1:
 * 
 * A = [3, 2, 1, 3]
 * Asorted = [1, 2, 3, 3]
 * Output 1:
 * 
 * 1
 * 
 * Input 2:
 * 
 * A = [1, 1, 3, 3]
 * 
 * Output 2:
 * 
 * -1
 */
public class NobleInteger {
    public static void main(String[] args) {
        int[] A = new int[] { 7, 3, 16, 10 };
        System.out.println(solve(A));

        A = new int[] { -1, -9, -2, -78, 0 };
        System.out.println(solve(A));
    }

    /*
     * 1. Sort the Array arr[] in ascending order. This step takes (O(nlogn)).
     * 2. Iterate through the array. Compare the value of index i to the number of
     * elements
     * after index i. If arr[i] equals the number of elements after arr[i], it is a
     * noble
     * Integer. Condition to check: (A[i] == length-i-1). This step takes O(n).
     * Note: Array may have duplicate elements. So, we should skip the elements
     * (adjacent elements in the sorted array) that are same.
     */
    public static int solve(int[] A) {
        int len = A.length;
        Arrays.sort(A);

        for (int i = 0; i < len; i++) {

            // skip, in case adjacenet elements are same,
            // this is because we need to find number of elements, smaller than the cur ele
            if (i < A.length - 1 && A[i] == A[i + 1])
                continue;

            // `(len - 1) - i` represents the number of elements smaller than A[i], in this
            // case.
            if (A[i] == (len - 1) - i)
                return 1;
        }
        return -1;
    }

}

/*
 * http://www.geeksforgeeks.org/noble-integers-in-an-array-count-of-greater-
 * elements-is-equal-to-value/
 */
