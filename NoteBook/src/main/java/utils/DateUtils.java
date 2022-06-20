package utils;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate getBeginOfWeek(LocalDate day) {
        LocalDate currentDate = LocalDate.now();
        switch (day.getDayOfWeek()){
            case MONDAY: return  day;
            case TUESDAY: return currentDate.minusDays(1);
            case WEDNESDAY: return currentDate.minusDays(2);
            case THURSDAY: return currentDate.minusDays(3);
            case FRIDAY: return currentDate.minusDays(4);
            case SATURDAY: return currentDate.minusDays(5);
            case SUNDAY: return currentDate.minusDays(6);
            default: return currentDate;
        }
    }

    public static LocalDate getEndWeek(LocalDate date) {
        return date.plusDays(6);
    }

    public static LocalDate getLastMonday(LocalDate date) {
        return getBeginOfWeek(date).minusWeeks(1);
    }

    public static LocalDate getNextMonday(LocalDate date) {
        return getBeginOfWeek(date).plusWeeks(1);
    }
}
