package ua.lviv.navpil.datetime;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {

    public static String dateToZuluString(Date date) {
        if (date == null) {
            return null;
        }
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return toZulu(instant);

    }

    public static String toZulu(Instant instant) {
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .withZone(ZoneOffset.UTC)
                .format(instant);
    }

    public static Date zuluStringToDate(String date) {
        if (date == null) {
            return null;
        }
        return new Date(Instant.parse(date).toEpochMilli());
    }

    public static String addToZuluString(String date, int duration) {
        return toZulu(Instant.parse(date).plus(duration, ChronoUnit.MINUTES));
    }
}
