package Essential150.LinkedList;

/*

Problem    :   https://leetcode.com/problems/lru-cache/
Solutions  :   https://youtu.be/nN36SSIMn1k

The LRUCache class implements a least recently used (LRU) cache using a combination of a HashMap and a doubly linked list. 
The HashMap provides fast key-value lookups, while the doubly linked list maintains the order of the cache entries based on their usage.
 
 The time complexity for both the get and put operations is O(1) since HashMap provides constant-time lookups and insertions. 
 The space complexity is O(capacity) since the cache size is limited to the specified capacity.
 */

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Node> map; // Map to store key-value pairs
    private Node start; // Start of the doubly linked list representing the LRU cache
    private Node end; // End of the doubly linked list representing the LRU cache
    private int capacity; // Maximum capacity of the cache

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        start = null;
        end = null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeFromDLL(node);
            setHeadDLL(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node == null) {
            node = map.get(key);
            node.val = value;
            removeFromDLL(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(end.key);
                removeFromDLL(end);
            }
            node = new Node(key, value);
        }
        map.put(key, node);
        setHeadDLL(node);
    }

    private void removeFromDLL(Node node) {
        if (node.prev == null) { // Start node
            start = node.next;
        } else if (node.next == null) { // End node
            end = node.prev;
            end.next = null;
        } else { // Some middle node
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
        }
    }

    private void setHeadDLL(Node node) {
        if (start == null) {
            start = node;
            end = node;
        } else {
            node.prev = null;
            node.next = start;
            start.prev = node;
            start = node;
        }
    }

    private static class Node {
        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */