package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/merge-two-sorted-lists/
Solutions  :   https://youtu.be/XIdigk956u0
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |          O(m+n)      |       O(1)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Recursive                            |          O(m+n)      |       O(m+n)     |

Recursive approach uses call stack hence space complexity is O(m+n) where as iterative approach 
modifies lists in-place.

*/

public class MergeSortedLists {

    // Iterative Approach
    public static ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curHead = head;

        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curHead.next = list1;
                    list1 = list1.next;
                } else {
                    curHead.next = list2;
                    list2 = list2.next;
                }

            } else if (list1 != null) {
                curHead.next = list1;
                list1 = list1.next;
            } else {
                curHead.next = list2;
                list2 = list2.next;
            }
            curHead = curHead.next;

        }

        return head.next;
    }

    // Recursive Approach
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        mergeListsTest();
    }

    public static void mergeListsTest() {
        // Test cases
        ListNode list1 = null;
        ListNode list2 = null;

        ListNode merged1 = mergeTwoListsIterative(list1, list2);
        printList(merged1); // Expected: null

        list1 = new ListNode(1);
        list2 = null;

        ListNode merged2 = mergeTwoListsIterative(list1, list2);
        printList(merged2); // Expected: 1

        list1 = null;
        list2 = new ListNode(1);

        ListNode merged3 = mergeTwoListsIterative(list1, list2);
        printList(merged3); // Expected: 1

        list1 = new ListNode(1);
        list2 = new ListNode(2);

        ListNode merged4 = mergeTwoListsIterative(list1, list2);
        printList(merged4); // Expected: 1 -> 2

        list1 = new ListNode(1, new ListNode(3));
        list2 = new ListNode(2, new ListNode(4));

        ListNode merged5 = mergeTwoListsIterative(list1, list2);
        printList(merged5); // Expected: 1 -> 2 -> 3 -> 4

        list1 = new ListNode(1, new ListNode(2));
        list2 = new ListNode(3, new ListNode(4));

        ListNode merged6 = mergeTwoListsIterative(list1, list2);
        printList(merged6); // Expected: 1 -> 2 -> 3 -> 4
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
