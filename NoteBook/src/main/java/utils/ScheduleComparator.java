package utils;

import models.Schedule;

import java.util.Comparator;


public class ScheduleComparator implements Comparator<Schedule> {

    @Override
    public int compare(Schedule o, Schedule o1) {
        if (!o.getDate().equals(o.getDate())) {
            return Integer.compare(o.getTime(), o1.getTime());
        }
        return o.getDate().compareTo(o1.getDate());
    }

}
