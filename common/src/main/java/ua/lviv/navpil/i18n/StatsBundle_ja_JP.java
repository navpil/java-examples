package ua.lviv.navpil.i18n;

import java.util.HashMap;
import java.util.ListResourceBundle;
import java.util.Map;
import java.util.stream.Collectors;

public class StatsBundle_ja_JP extends ListResourceBundle {

    private static final Object[][] contents;
    static {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("GDP", 21300);
        hashMap.put("Population", 125449773);
        hashMap.put("Literacy", 0.99);

        contents = hashMap.entrySet().stream().map(StatsBundle_ja_JP::fromEntry).collect(Collectors.toList()).toArray(new Object[0][]);
    }

    private static Object[] fromEntry(Map.Entry<String, Object> entry) {
        return new Object[]{entry.getKey(), entry.getValue()};
    }

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
