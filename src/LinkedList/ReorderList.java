package LinkedList;

/**
 * @author jakadam on 2019-12-15
 */

/**
 * Given a singly linked list
 *
 * L: L0 → L1 → … → Ln-1 → Ln,
 * reorder it to:
 *
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * You must do this in-place without altering the nodes’ values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null)
            return A;

        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l2Start = slow.next;
        slow.next = null;

        ListNode cur = l2Start, prev = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode ptr1 = A, ptr2 = prev;
        ListNode ansHead = dummyHead;

        while (!(ptr1 == null && ptr2 == null)) {
            if (ptr1 != null) {
                dummyHead.next = ptr1;
                ptr1 = ptr1.next;
                dummyHead = dummyHead.next;
            }

            if (ptr2 != null) {
                dummyHead.next = ptr2;
                ptr2 = ptr2.next;
                dummyHead = dummyHead.next;
            }
        }
        return ansHead.next;
    }
}
