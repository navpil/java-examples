package ua.lviv.navpil.spi;

import java.util.ServiceLoader;

/**
 * For this example to work, change the run configuration, so that classpath uses module spiimpl
 */
public class Dictionaries {

    public static void main(String[] args) {
        ServiceLoader<DictionarySpi> dicts = ServiceLoader.load(DictionarySpi.class);
        String language = "ua";

        DictionarySpi dictionary = null;
        for (DictionarySpi dict : dicts) {
            if (dict.isLanguageSupported(language)) {
                dictionary = dict;
                break;
            }
        }
        if (dictionary != null) {
            System.out.println(dictionary.tranlate("hello"));
        } else {
            System.out.printf("No dictionary supports %s%n", language);
        }


    }
}
