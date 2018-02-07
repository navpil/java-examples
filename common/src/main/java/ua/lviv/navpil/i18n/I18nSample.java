package ua.lviv.navpil.i18n;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class I18nSample {

    public static void main(String[] args) throws UnsupportedEncodingException {


        List<Locale> locales = Arrays.asList(new Locale("uk", "UA"), new Locale("at", "UT"));
        for (Locale locale : locales) {
            System.out.printf("Locale: %s%n", locale);

            ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);

//        System.out.println(new String(greetings.getBytes("ISO-8859-1"), "UTF-8"));

            //You have to use the \\ u notation in the properties file to get it rendered correctly.
            // IntelliJ Idea has a problem with this - have a look at the MessagesBundle_uk_UA in the notepad and intellij idea
            // Unless you add the messages bundle by using intellij idea functionality - then it works fine (like at_UT)
            System.out.println(messages.getString("greetings"));
            System.out.println(messages.getString("inquiry"));
            System.out.println(messages.getString("farewell"));
        }

        ResourceBundle bundle = ResourceBundle.getBundle("ua.lviv.navpil.i18n.StatsBundle", new Locale("ja", "JP"));
        System.out.println(bundle.getObject("GDP"));
    }
}
