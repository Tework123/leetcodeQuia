package MeetingRoomsII;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int minMeetingRooms(List<Interval> intervals) {
//        Сортируем интервалы по start.
//        Поддерживаем мин-кучу (PriorityQueue) по end.
//        Если interval.start >= minEnd → переиспользуем комнату (удаляем end из кучи).
//        В любом случае добавляем interval.end в кучу.
        return 1;
    }
}
