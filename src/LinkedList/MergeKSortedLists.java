package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        /*
         * NOTE: PriorityQueue DOES NOT allow adding NULL values, throws NPE
         * Use LinkedList instead if NULL values need to be added.
         */
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test cases
        MergeKSortedLists solution = new MergeKSortedLists();

        // Example 1
        ListNode[] lists1 = new ListNode[3];
        lists1[0] = new ListNode(1);
        lists1[0].next = new ListNode(4);
        lists1[0].next.next = new ListNode(5);
        lists1[1] = new ListNode(1);
        lists1[1].next = new ListNode(3);
        lists1[1].next.next = new ListNode(4);
        lists1[2] = new ListNode(2);
        lists1[2].next = new ListNode(6);

        System.out.println("Merged list 1:");
        solution.printList(solution.mergeKLists(lists1));
        System.out.println();

        // Example 2
        ListNode[] lists2 = new ListNode[0];

        System.out.println("Merged list 2:");
        solution.printList(solution.mergeKLists(lists2));
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
