package ua.lviv.navpil.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class KazakhstanMidnight {

    private static final ZoneId CPH = ZoneId.of("Europe/Copenhagen");
    public static void main(String[] args) {

        LocalDateTime todayNoon = LocalDateTime.of(LocalDate.now(), LocalTime.NOON);
        Instant todayCphNoon = todayNoon.atZone(CPH).toInstant();
        Instant tomorrowCphNoon = todayNoon.plus(1, ChronoUnit.DAYS).atZone(CPH).toInstant();


        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(todayCphNoon, CPH);

//        System.out.println(zonedDateTime.with(ChronoField.HOUR_OF_DAY, 23));
        System.out.println(zonedDateTime);

        ZonedDateTime mid = ZonedDateTime.ofInstant(tomorrowCphNoon, CPH).with(ChronoField.HOUR_OF_DAY, 0);


        System.out.println(mid);

        if (mid.isBefore(mid)) {
            System.out.println("Span midnight");

        }
    }


//
//
//
//
//
//        LocalTime midnight = LocalTime.MIDNIGHT;
//        LocalDate today = LocalDate.now();
////
//        LocalDateTime mt = LocalDateTime.of(today, midnight);
////
////        System.out.println(mt);
////
//        ZonedDateTime of = ZonedDateTime.of(mt, CPH);
//        System.out.println(of);
////
////        System.out.println(of.withZoneSameInstant(CPH));
//    }

}
