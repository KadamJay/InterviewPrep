package Essential150.LinkedList;
/*
Problem    :   https://leetcode.com/problems/reorder-list/
Solutions  :   https://youtu.be/S5bfdUTrKLM
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |          O(N)      |       O(1)       |


The time complexity of the solution is O(n), where n is the number of nodes in the list. 
The space complexity is O(1) since the reordering is done in-place without requiring additional data structures.

*/

public class ReorderList {
    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Step 1: Find the middle node to split the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfStart = slow.next;
        slow.next = null;

        // Step 2: Reverse the second half of the list
        ListNode reversedSecondHalf = reverseList(secondHalfStart);

        // Step 3: Merge the first half and reversed second half
        mergeLists(head, reversedSecondHalf);

        return head;
    }

    private ListNode reverseList(ListNode head) {
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

    private void mergeLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (head1 != null || head2 != null) {
            if (head1 != null) {
                current.next = head1;
                head1 = head1.next;
                current = current.next;
            }

            if (head2 != null) {
                current.next = head2;
                head2 = head2.next;
                current = current.next;
            }
        }

        dummy.next = null;
    }

    public static void main(String[] args) {
        // Test cases
        ReorderList solution = new ReorderList();

        // Example 1
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        System.out.println("Original list 1:");
        solution.printList(list1);
        ListNode reorderedList1 = solution.reorderList(list1);
        System.out.println("Reordered list 1:");
        solution.printList(reorderedList1);
        System.out.println();

        // Example 2
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(4);
        list2.next.next.next.next = new ListNode(5);

        System.out.println("Original list 2:");
        solution.printList(list2);
        ListNode reorderedList2 = solution.reorderList(list2);
        System.out.println("Reordered list 2:");
        solution.printList(reorderedList2);
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
