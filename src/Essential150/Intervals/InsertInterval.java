package Essential150.Intervals;

/*
Problem    :   https://leetcode.com/problems/insert-interval/
Solutions  :   https://youtu.be/A8NUOmlwOlM
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |    O(n)              |          O(n)    |

The time complexity of the insert method is O(n),  because the method iterates through each 
interval once to merge or add them to the result list.

The space complexity is O(n), as the method uses additional space to store the merged 
intervals in a list. The size of the result list can be at most the same as the number 
of intervals in the input array.
*/

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        for (int[] curInterval : intervals) {
            if (newInterval == null || curInterval[1] < newInterval[0]) {
                // No overlap, add the current interval as it is
                mergedIntervals.add(curInterval);
            } else if (newInterval[1] < curInterval[0]) {
                // No more overlap, add the new interval and current interval
                mergedIntervals.add(newInterval);
                mergedIntervals.add(curInterval);
                newInterval = null;
            } else {
                // Overlap exists, merge the intervals
                newInterval[0] = Math.min(curInterval[0], newInterval[0]);
                newInterval[1] = Math.max(curInterval[1], newInterval[1]);
            }
        }

        if (newInterval != null) {
            // Add the new interval if it is not merged
            mergedIntervals.add(newInterval);
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        insertTest();
    }

    public static void insertTest() {
        // Test cases
        int[][] intervals1 = {};
        int[] newInterval1 = { 2, 5 };
        int[][] result1 = insert(intervals1, newInterval1);
        printIntervals(result1); // Expected: [[2, 5]]

        int[][] intervals2 = { { 1, 3 }, { 6, 9 } };
        int[] newInterval2 = { 2, 5 };
        int[][] result2 = insert(intervals2, newInterval2);
        printIntervals(result2); // Expected: [[1, 5], [6, 9]]

        int[][] intervals3 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval3 = { 4, 8 };
        int[][] result3 = insert(intervals3, newInterval3);
        printIntervals(result3); // Expected: [[1, 2], [3, 10], [12, 16]]
    }

    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
        System.out.println();
    }
}
