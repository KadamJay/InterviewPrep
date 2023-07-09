package Essential150.Intervals;

/*
Problem    :   https://leetcode.com/problems/non-overlapping-intervals/
Solutions  :   https://youtu.be/nONCGxWoUfM
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |   O(n log n)         |       O(1)       |

*/

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int eraseCount = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd <= intervals[i][0]) {
                // Non-overlapping interval
                prevEnd = intervals[i][1];
            } else {
                // Overlapping interval
                // erase the one which ends first, as this reduces the chance of
                // overlapping with incoming interval
                prevEnd = Math.min(intervals[i][1], prevEnd);
                eraseCount++;
            }
        }

        return eraseCount;
    }

    public static void main(String[] args) {
        eraseOverlapIntervalsTest();
    }

    public static void eraseOverlapIntervalsTest() {
        // Test cases
        int[][] intervals1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        int result1 = eraseOverlapIntervals(intervals1);
        System.out.println(result1); // Expected: 1

        int[][] intervals2 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
        int result2 = eraseOverlapIntervals(intervals2);
        System.out.println(result2); // Expected: 2

        int[][] intervals3 = { { 1, 2 }, { 2, 3 } };
        int result3 = eraseOverlapIntervals(intervals3);
        System.out.println(result3); // Expected: 0
    }
}
