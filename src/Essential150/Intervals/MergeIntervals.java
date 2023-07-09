package Essential150.Intervals;
/*
Problem    :   https://leetcode.com/problems/merge-intervals/
Solutions  :   https://youtu.be/44H3cEC2fFM
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |   O(n log n)         |       O(n)       |


The space complexity is O(n), as the method uses additional space to store the merged 
intervals in a list. The size of the result list can be at most the same as the number 
of intervals in the input array.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        // Sort intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();

        for (int[] interval : intervals) {
            if (mergedIntervals.isEmpty() || mergedIntervals.get(mergedIntervals.size() - 1)[1] < interval[0]) {
                // No overlap, add the interval as it is
                mergedIntervals.add(interval);
            } else {
                // Overlap exists, merge the intervals
                mergedIntervals.get(mergedIntervals.size() - 1)[1] = Math
                        .max(mergedIntervals.get(mergedIntervals.size() - 1)[1], interval[1]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        mergeTest();
    }

    public static void mergeTest() {
        // Test cases
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result1 = merge(intervals1);
        printIntervals(result1); // Expected: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        int[][] result2 = merge(intervals2);
        printIntervals(result2); // Expected: [[1, 5]]

        int[][] intervals3 = { { 1, 4 }, { 2, 3 } };
        int[][] result3 = merge(intervals3);
        printIntervals(result3); // Expected: [[1, 4]]
    }

    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}