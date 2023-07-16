package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/linked-list-cycle/
Solutions  :   https://youtu.be/gBTe7lFR3vc
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |          O(N)        |       O(1)       |



*/

public class ListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}