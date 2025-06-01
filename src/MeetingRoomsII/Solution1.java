package MeetingRoomsII;

import java.util.ArrayList;
import java.util.List;

//https://neetcode.io/problems/meeting-schedule-ii
// O(n2)
class Solution1 {

    public int minMeetingRooms(List<Interval> intervals) {
        List<List<Interval>> intervalList = new ArrayList<>();

        for (Interval interval : intervals) {

            if (intervalList.isEmpty()) {
                List<Interval> newInterDayList = new ArrayList<>();
                newInterDayList.add(interval);
                intervalList.add(newInterDayList);
                continue;
            }

            boolean flag1 = false;
            for (List<Interval> interDayList : intervalList) {
                int res = 0;
                for (Interval oldInter : interDayList) {
                    if ((interval.start <= oldInter.start && interval.end <= oldInter.end) ||
                            (interval.start >= oldInter.start && interval.start >= oldInter.end)) {
                        res += 1;
                    }
                }
                if (res == interDayList.size()) {
                    interDayList.add(interval);
                    flag1 = true;
                    break;
                }
            }

            if (!flag1) {
                List<Interval> newInterDayList = new ArrayList<>();
                newInterDayList.add(interval);
                intervalList.add(newInterDayList);
            }
        }

        return intervalList.size();
    }
}



