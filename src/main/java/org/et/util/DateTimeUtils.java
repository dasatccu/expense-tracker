package org.et.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeUtils {

    private static final String TAG = "DateTimeUtils";

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    public static final DateTimeFormatter ISO_DATE_FORMAT = DateTimeFormatter.ISO_LOCAL_DATE;
    public static final DateTimeFormatter HUMAN_FRIENDLY = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");
    public static final DateTimeFormatter CUSTOM_FORMAT = DateTimeFormatter.ofPattern("dd_MM_yyyy - HH:mm:ss");

    public static LocalDate getToday() {
        LocalDate today = LocalDate.now();
        LogService.info(TAG, "getToday() => " + today);
        return today;
    }

    public static LocalDateTime getNow() {
        LocalDateTime now = LocalDateTime.now();
        LogService.info(TAG, "getNow() => " + now);
        return now;
    }

    public static String formatDate(LocalDate date) {
        String formatted = date.format(DATE_FORMAT);
        LogService.debug(TAG, "formatDate(" + date + ") => " + formatted);
        return formatted;
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        String formatted = dateTime.format(DATE_TIME_FORMAT);
        LogService.debug(TAG, "formatDateTime(" + dateTime + ") => " + formatted);
        return formatted;
    }

    public static String formatHuman(LocalDate date) {
        String formatted = date.format(HUMAN_FRIENDLY.withLocale(Locale.ENGLISH));
        LogService.debug(TAG, "formatHuman(" + date + ") => " + formatted);
        return formatted;
    }

    public static LocalDate parseDate(String dateStr) {
        try {
            LocalDate parsed = LocalDate.parse(dateStr, DATE_FORMAT);
            LogService.info(TAG, "parseDate(" + dateStr + ") => " + parsed);
            return parsed;
        } catch (Exception e) {
            LogService.error(TAG, "Error parsing date: " + dateStr, e);
            throw e;
        }
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) {
        try {
            LocalDateTime parsed = LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMAT);
            LogService.info(TAG, "parseDateTime(" + dateTimeStr + ") => " + parsed);
            return parsed;
        } catch (Exception e) {
            LogService.error(TAG, "Error parsing dateTime: " + dateTimeStr, e);
            throw e;
        }
    }

    public static LocalDateTime startOfDay(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LogService.debug(TAG, "startOfDay(" + date + ") => " + start);
        return start;
    }

    public static LocalDateTime endOfDay(LocalDate date) {
        LocalDateTime end = date.atTime(LocalTime.MAX);
        LogService.debug(TAG, "endOfDay(" + date + ") => " + end);
        return end;
    }

    public static long toEpochMillis(LocalDateTime dateTime) {
        long millis = dateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        LogService.debug(TAG, "toEpochMillis(" + dateTime + ") => " + millis);
        return millis;
    }

    public static LocalDateTime fromEpochMillis(long millis) {
        LocalDateTime dateTime = Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LogService.debug(TAG, "fromEpochMillis(" + millis + ") => " + dateTime);
        return dateTime;
    }

    public static String getTodayFormattedDateTime() {
        LocalDateTime now = getNow(); // already logs the time
        String formatted = now.format(CUSTOM_FORMAT);
        LogService.info(TAG, "getTodayFormattedDateTime() => " + formatted);
        return formatted;
    }
}
