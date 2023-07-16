package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/find-the-duplicate-number/
Solutions  :   https://youtu.be/PvrxZaH_eZ4
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |          O(N)        |       O(1)       |

Why the algo works: https://youtu.be/PvrxZaH_eZ4

This is Cycle Start Point Detection in LinkedList

*/
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];

        while (fast < nums.length) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                slow = nums[0];

                while (slow != fast) {
                    slow = nums[slow];
                    fast = nums[fast];
                }
                return slow;
            }
        }

        return 0;
    }
}
