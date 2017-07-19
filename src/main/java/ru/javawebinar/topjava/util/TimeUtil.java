package ru.javawebinar.topjava.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * GKislin
 * 07.01.2015.
 */
public class TimeUtil {
    public static String isoPattern = "yyyy-MM-dd'T'HH:mm";
    public static String dateTimePattern = "yyyy.MM.dd HH:mm";
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimePattern);

    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }
}
