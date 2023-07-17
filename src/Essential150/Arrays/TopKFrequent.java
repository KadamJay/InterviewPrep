package Essential150.Arrays;

/*
Problem    :   https://leetcode.com/problems/top-k-frequent-elements/
Solutions  :   https://youtu.be/YPTqKIgVk-k
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Buckets                              |          O(n)        |       O(n)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | Heap                                 |     O(n log k)       |       O(n)       |

The time and space complexity of the version using buckets is as follows:

Time Complexity: O(n)

Counting the frequency of each element and storing it in the frequency map takes O(n) time.
Iterating over the frequency map to create buckets of frequencies takes O(n) time.
Reading the frequency array to return the top k frequent elements takes O(n) time.
Space Complexity: O(n)

The space required for the frequency map is O(n) to store the frequency of each element.
The space required for the buckets array is also O(n) in the worst case if each element has a unique frequency.
Overall, both the time and space complexity are O(n) for the version using buckets. 
This approach is more efficient than using a PriorityQueue when k is relatively small compared to n because it 
avoids the overhead of maintaining a heap.
===================================================================================================================

The time and space complexity of the version using a PriorityQueue is as follows:

Time Complexity: O(n log k)

Building the frequency map takes O(n) time.
Adding elements to the PriorityQueue takes O(log k) time, and this is done for each element, resulting in a total of O(n log k) time.
Polling the top k frequent elements from the PriorityQueue takes O(k log k) time.
Space Complexity: O(n)

The space required for the frequency map is O(n) to store the frequency of each element.
The PriorityQueue can have a maximum of k elements, so its space complexity is O(k).
Overall, the space complexity is dominated by the frequency map, resulting in O(n) space.
Note: If k is relatively small compared to n (i.e., k << n), the time complexity can be approximated as O(n).
However, in the worst case when k is close to n (i.e., k ≈ n), the time complexity is O(n log n).
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequent {
    @SuppressWarnings("unchecked")
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Counting frequency and storing in map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Creating buckets to store elements with their frequencies
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Reading the frequency array to return the top k frequent elements
        int[] result = new int[k];
        int count = 0;
        for (int i = buckets.length - 1; i >= 0 && count < k; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size() && count < k; j++) {
                    result[count] = buckets[i].get(j);
                    count++;
                }
            }
        }

        return result;
    }
}

// With Heap
class TopKFrequentWithHeap {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Counting frequency and storing in map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Using a PriorityQueue to get top k frequent elements
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        pq.addAll(freqMap.keySet());

        // Storing the top k frequent elements in the result array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
