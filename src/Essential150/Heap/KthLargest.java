package Essential150.Heap;
/*
Problem    :   https://leetcode.com/problems/kth-largest-element-in-a-stream/
Solutions  :   https://youtu.be/hOjcdrqMoQ8
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |     O(log k)         |      O(k)        |

Time Complexity: O(log k) for the add method, where k is the size of the minHeap.
Space Complexity: O(k) for the minHeap, as it stores the kth largest elements.
*/

import java.util.PriorityQueue;

public class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        this.k = k;

        // Initialize the minHeap with the first k elements
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        // If the minHeap size exceeds k, remove the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // Return the current kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = { 4, 5, 8, 2 }; // k = 3, initial kth largest: 4, 5, 8
        int[] nums2 = { 10, 3, 7, 6, 5 }; // k = 2, initial kth largest: 5, 6

        KthLargest kthLargest1 = new KthLargest(3, nums1);
        KthLargest kthLargest2 = new KthLargest(2, nums2);

        System.out.println("Current kth largest (nums1): " + kthLargest1.add(3)); // 4
        System.out.println("Current kth largest (nums2): " + kthLargest2.add(2)); // 6
    }
}
