package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/reverse-linked-list/
Solutions  :   https://youtu.be/G0_I-ZF0S38 | https://www.youtube.com/watch?v=ugQ2DVJJroc
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |          O(n)        |       O(1)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Recursive                            |          O(n)        |       O(n)        |

Recursive approach uses call stack hence space complexity is O(n) where as iterative approach 
modifies lists in-place.

*/
public class ReverseLinkedList {

    // Iterative Approach
    public static ListNode reverseListIterative(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    // Recursive Approach
    public static ListNode reverseListRecursive(ListNode head) {
        return reverse(null, head);
    }

    private static ListNode reverse(ListNode previous, ListNode current) {
        if (current == null)
            return previous;

        ListNode next = current.next;
        current.next = previous;

        return reverse(current, next);
    }

    public static void main(String[] args) {
        LinkedListUtils.linkedListTest();
    }
}

class LinkedListUtils {
    public static void linkedListTest() {
        // Test cases
        ListNode list1 = null;
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(1, new ListNode(2));
        ListNode list4 = new ListNode(1,
                new ListNode(2, new ListNode(3)));

        // Reverse lists using iterative approach
        ListNode reversed1 = ReverseLinkedList.reverseListIterative(list1);
        ListNode reversed2 = ReverseLinkedList.reverseListIterative(list2);
        ListNode reversed3 = ReverseLinkedList.reverseListIterative(list3);
        ListNode reversed4 = ReverseLinkedList.reverseListIterative(list4);

        System.out.println("Iterative Approach:");
        printList(reversed1); // Expected: null
        printList(reversed2); // Expected: 1
        printList(reversed3); // Expected: 2 -> 1
        printList(reversed4); // Expected: 3 -> 2 -> 1
        System.out.println();

        // Reverse lists using recursive approach
        reversed1 = ReverseLinkedList.reverseListRecursive(list1);
        reversed2 = ReverseLinkedList.reverseListRecursive(list2);
        reversed3 = ReverseLinkedList.reverseListRecursive(list3);
        reversed4 = ReverseLinkedList.reverseListRecursive(list4);

        System.out.println("Recursive Approach:");
        printList(reversed1); // Expected: null
        printList(reversed2); // Expected: 1
        printList(reversed3); // Expected: 2 -> 1
        printList(reversed4); // Expected: 3 -> 2 -> 1
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}