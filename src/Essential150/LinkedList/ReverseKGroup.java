package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/reverse-nodes-in-k-group/
Solutions  :   Iterative: https://youtu.be/1UOPsfP85V4  | Recursive: https://youtu.be/LCRGV8avvUY
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |          O(N)        |       O(1)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Recursive                            |          O(N)        |       O(N)       |


The space complexity of the recursive solution is O(N), as the recursive calls utilize the call stack. 

*/
// Iterative solution
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupTail = dummy;

        while (head != null) {
            ListNode groupStart = head;
            ListNode groupEnd = getGroupEnd(head, k);

            if (groupEnd == null) {
                break;
            }

            ListNode nextGroupStart = groupEnd.next;
            groupEnd.next = null;

            prevGroupTail.next = reverseGroup(groupStart);
            groupStart.next = nextGroupStart;
            prevGroupTail = groupStart;
            head = nextGroupStart;
        }

        return dummy.next;
    }

    // Get the end node of the group given the start node and group size k
    private ListNode getGroupEnd(ListNode start, int k) {
        ListNode curr = start;

        for (int i = 1; i < k; i++) {
            if (curr == null) {
                return null; // Reached the end of the list before completing the group
            }
            curr = curr.next;
        }

        return curr;
    }

    // Reverse the nodes in a group and return the new head of the reversed group
    private ListNode reverseGroup(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}

// Recursive solution
class ReverseKGroupRecursive {

    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if the number of nodes is less than k
        ListNode curr = head;
        int count = 0;
        while (count < k && curr != null) {
            curr = curr.next;
            count++;
        }
        if (count < k) {
            return head;
        }

        // Reverse the first k nodes
        ListNode prev = null;
        ListNode next = null;
        curr = head;
        count = 0;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Recursively reverse the remaining nodes
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}