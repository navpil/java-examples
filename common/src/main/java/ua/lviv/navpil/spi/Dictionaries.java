package ua.lviv.navpil.spi;

import java.util.ServiceLoader;

/**
 * For this example to work classpath should use module "spiimpl"
 * This dependency is included in the pom.xml.
 * You may comment it out to see how this example will fail
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
