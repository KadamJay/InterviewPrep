package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Solutions  :   https://youtu.be/XVuQxVej6y8
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |          O(N)        |       O(1)       |


The time complexity of the solution is O(n), where n is the number of nodes in the list. 
The space complexity is O(1) since the reordering is done in-place without requiring additional data structures.

*/
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // Move fast pointer n+1 nodes ahead
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        // dummy & n+1 is adjusted for getting access to the prev node
        // Move both pointers until the fast pointer reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test cases
        RemoveNthFromEnd solution = new RemoveNthFromEnd();

        // Example 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(5);

        System.out.println("Original list 1:");
        solution.printList(list1);
        ListNode modifiedList1 = solution.removeNthFromEnd(list1, 2);
        System.out.println("Modified list 1:");
        solution.printList(modifiedList1);
        System.out.println();

        // Example 2
        ListNode list2 = new ListNode(1);

        System.out.println("Original list 2:");
        solution.printList(list2);
        ListNode modifiedList2 = solution.removeNthFromEnd(list2, 1);
        System.out.println("Modified list 2:");
        solution.printList(modifiedList2);
    }

    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
