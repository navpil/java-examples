package ua.lviv.navpil.spisupport;

import ua.lviv.navpil.spi.DictionarySpi;

import java.util.HashMap;
import java.util.Map;

public class UkrainianDictionary implements DictionarySpi {

    private final Map<String, String> words;

    public UkrainianDictionary() {
        words = new HashMap<String, String>();
        words.put("hello", "привіт");
    }

    public boolean isLanguageSupported(String language) {
        return "ua".equals(language);
    }

    public String tranlate(String word) {
        return words.get(word);
    }
}
