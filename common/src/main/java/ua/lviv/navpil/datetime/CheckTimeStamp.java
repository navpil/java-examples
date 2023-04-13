package ua.lviv.navpil.datetime;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class CheckTimeStamp {

    public static void main(String[] args) {


        Timestamp timestamp = new Timestamp(new Date().getTime());

        System.out.println(timestamp);

        System.out.println(DateUtils.dateToZuluString(timestamp));
        ZonedDateTime utc = ZonedDateTime.of(timestamp.toLocalDateTime(), ZoneId.of("UTC"));

        System.out.println(utc);

        Date date = new Date(utc.toInstant().toEpochMilli());
        System.out.println(DateUtils.dateToZuluString(date));

        System.out.println("NILS");
        Date nilsDate = Date.from(
                ZonedDateTime.of(
                        LocalDateTime.ofInstant(
                                timestamp.toInstant(),
                                ZoneId.of("UTC")
                        ),
                        ZoneId.systemDefault()
                ).toInstant()
        );
        System.out.println(nilsDate);
        System.out.println(DateUtils.dateToZuluString(nilsDate));
        System.out.println(ZonedDateTime.of(new Timestamp(nilsDate.getTime()).toLocalDateTime(), ZoneId.of("UTC")));

    }

/*
2018-07-24 10:03:38.045
2018-07-24T07:03:38Z
2018-07-24T10:03:38.045Z[UTC]
2018-07-24T10:03:38Z
NILS
Tue Jul 24 07:03:38 EEST 2018
2018-07-24T04:03:38Z
2018-07-24T07:03:38.045Z[UTC]
 */
}
