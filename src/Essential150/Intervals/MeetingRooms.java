package Essential150.Intervals;

/*
Problem    :   https://www.lintcode.com/problem/920/
Solutions  :   https://youtu.be/PaJxqZVPhbg
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |   O(n log n)         |       O(1)       |

*/

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // Scheduling conflict
            }
        }

        return true; // No conflicts
    }

    public static void main(String[] args) {
        // Test cases
        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        boolean result1 = canAttendMeetings(intervals1);
        System.out.println(result1); // Expected: false

        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        boolean result2 = canAttendMeetings(intervals2);
        System.out.println(result2); // Expected: true

        int[][] intervals3 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        boolean result3 = canAttendMeetings(intervals3);
        System.out.println(result3); // Expected: true

        int[][] intervals4 = { { 1, 3 }, { 2, 4 }, { 5, 7 } };
        boolean result4 = canAttendMeetings(intervals4);
        System.out.println(result4); // Expected: false
    }
}
