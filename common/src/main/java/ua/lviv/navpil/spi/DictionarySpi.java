package ua.lviv.navpil.spi;

public interface DictionarySpi {

    boolean isLanguageSupported(String language);

    String tranlate(String word);

}
