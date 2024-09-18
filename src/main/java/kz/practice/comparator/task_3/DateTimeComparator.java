package kz.practice.comparator.task_3;

import java.util.Comparator;

public class DateTimeComparator implements Comparator<DateTime> {
    public int compare(DateTime dt1, DateTime dt2) {
        if (dt1.year != dt2.year) {
            return Integer.compare(dt1.year, dt2.year);
        } else if (dt1.month != dt2.month) {
            return Integer.compare(dt1.month, dt2.month);
        } else if (dt1.day != dt2.day) {
            return Integer.compare(dt1.day, dt2.day);
        } else if (dt1.hours != dt2.hours) {
            return Integer.compare(dt1.hours, dt2.hours);
        } else if (dt1.minutes != dt2.minutes) {
            return Integer.compare(dt1.minutes, dt2.minutes);
        } else {
            return Integer.compare(dt1.seconds, dt2.seconds);
        }
    }
}