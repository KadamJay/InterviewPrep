package Essential150.Intervals;

/*
Problem    :   https://leetcode.com/problems/meeting-rooms-ii/description/
Solutions  :   https://youtu.be/FdzJmTCVyJU
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |   O(n log n)         |       O(n)       |

*/
import java.util.Arrays;

public class MeetingRoomsII {

    public static int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] startTimes = new int[len];
        int[] endTimes = new int[len];

        for (int i = 0; i < len; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int roomCount = 0, count = 0;
        int startPtr = 0, endPtr = 0;

        // based on start and end time, count represents the number of on-going meetings
        // at
        // any givent moment
        while (startPtr < len) {
            if (startTimes[startPtr] < endTimes[endPtr]) {
                count++;
                startPtr++;
            } else {
                count--;
                endPtr++;
            }
            roomCount = Math.max(roomCount, count);
        }

        return roomCount;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] intervals1 = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        int result1 = minMeetingRooms(intervals1);
        System.out.println(result1); // Expected: 2

        int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
        int result2 = minMeetingRooms(intervals2);
        System.out.println(result2); // Expected: 1

        int[][] intervals3 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int result3 = minMeetingRooms(intervals3);
        System.out.println(result3); // Expected: 1

        int[][] intervals4 = { { 1, 3 }, { 2, 4 }, { 5, 7 } };
        int result4 = minMeetingRooms(intervals4);
        System.out.println(result4); // Expected: 2
    }
}
