package ua.lviv.navpil.datetime;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class TestDateTime {

    public static void main(String[] args) {
        DayOfWeek dow = DayOfWeek.FRIDAY;

        Locale locale = Locale.forLanguageTag("uk-UA");

        for (TextStyle value : TextStyle.values()) {
            System.out.println(value + ": " + dow.getDisplayName(value, locale));
        }

    }
}
