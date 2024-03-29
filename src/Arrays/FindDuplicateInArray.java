package Arrays;

/**
 * @author jakadam on 2020-01-06
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Given a read only array of n + 1 integers between 1 and n, find one number
 * that repeats
 * in linear time using less than O(n) space and traversing the stream
 * sequentially O(1) times.
 *
 * Sample Input:
 *
 * [3 4 1 4 1]
 * Sample Output:
 *
 * 1
 * If there are multiple possible answers ( like in the sample case above ),
 * output any one.
 *
 * If there is no duplicate, output -1
 */
public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 1, 4, 1 };
        // System.out.println(duplicateWithXOR(nums));
        System.out.println(duplicateWithTwoPointers(nums));
        System.out.println(duplicateWithHashSet(nums));
    }

    /**
     * Using HashSet
     * 
     * @param a
     * @return
     */
    public static int duplicateWithHashSet(int[] a) {
        /*
         * - Questions to ask in similar problems.
         * - 1. Does the array have -ve nums or 0.
         * - 2. How many numbers can repeat and how many times they can repeat.
         * - 3. Does the Sequence of output matters
         * - 4. Is it ok to modify the input, if extra space usage is not allowed.
         */

        // Approach 1: Since input is read only, use a Set. It will take O(n) space

        Set<Integer> set = new HashSet<Integer>();

        for (int num : a) {
            if (set.contains(num) == true)
                return num;
            else
                set.add(num);
        }

        return -1;
    }

    /**
     * Using TwoPointers
     * 
     * @param a
     * @return
     */
    public static int duplicateWithTwoPointers(int[] a) {
        // Important! Understrand this. Similar idea to finding a loop in
        // a linked list. Floyd's cycle detection.
        int slow = 0, fast = 0;
        do {
            slow = a[slow];
            fast = a[a[fast]];
        } while (slow != fast);
        // They meet somewhere in the loop
        slow = 0;
        while (slow != fast) {
            slow = a[slow];
            fast = a[fast];
        }
        return slow;
    }
}
