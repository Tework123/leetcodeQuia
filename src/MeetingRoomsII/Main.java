package MeetingRoomsII;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Interval interval1 = new Interval(0, 40);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);
        Interval interval4 = new Interval(4, 9);
        Interval interval5 = new Interval(9, 11);

        Solution1 solution = new Solution1();
        List<Interval> intervals = new ArrayList<>();
//        intervals.add(interval1);
//        intervals.add(interval2);
//        intervals.add(interval3);
        intervals.add(interval4);
        intervals.add(interval5);


        int result = solution.minMeetingRooms(intervals);
        System.out.println(result);
    }
}
