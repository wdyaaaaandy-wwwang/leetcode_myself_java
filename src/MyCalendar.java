/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 729. 我的日程安排表 I 中等
 * @date 2025/1/3 10:27
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
public class MyCalendar {
    List<List<Integer>> lists = new ArrayList<>();
    int current_start;
    int current_end;

    public MyCalendar() {
        current_start = -1;
        current_end = -1;
    }

    public boolean book(int startTime, int endTime) {
        boolean result = false;
        List<Integer> list = new ArrayList<>();
        list.add(startTime);
        list.add(endTime);
        if (lists.isEmpty()) {
            result = true;
            current_start = startTime;
            current_end = endTime;
            lists.add(list);
        }else {
            if((startTime>=current_end&&endTime>current_end)) {
                current_end=endTime;
                result = true;
                lists.add(list);
            } else if (endTime<=current_start&&startTime<current_start) {
                current_start=startTime;
                result = true;
                lists.add(list);
            } else {
                result = false;
            }
        }
        return result;
    }
}
