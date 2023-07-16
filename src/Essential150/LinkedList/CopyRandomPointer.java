package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/copy-list-with-random-pointer/
Solutions  :   https://youtu.be/uBjpRedaNKQ
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative(MAP)                       |          O(N)        |       O(N)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Iterative(Without Map)               |          O(N)        |       O(1)       |

Why the algo works: https://youtu.be/PvrxZaH_eZ4

This is Cycle Start Point Detection in LinkedList

*/

import java.util.HashMap;
import java.util.Map;

class CopyRandomPointerWithMap {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node cur = head;
        // add nodes to map with respective copyNodes
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // copy the next and random pointers
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);

    }
}

public class CopyRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node cur = head;

        // First round: make copy of each node and insert it next to the original node
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // Second round: assign random pointers for the copy nodes
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }

        // Third round: restore the original list and extract the copy list
        cur = head;
        Node copyHead = head.next;
        Node copyCur = copyHead;

        while (cur != null) {
            cur.next = cur.next.next;
            if (copyCur.next != null)
                copyCur.next = copyCur.next.next;
            cur = cur.next;
            copyCur = copyCur.next;
        }

        return copyHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}