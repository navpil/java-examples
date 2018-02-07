package ua.lviv.navpil.i18n;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Collectors;

public class NumberFormatDemo {

    public static void main(String[] args) {
        testLocale(Locale.US);
        testLocale(Locale.GERMANY);

        testLocale(Locale.FRANCE);
        testLocale(new Locale("uk", "UA"));
        testLocale(new Locale("th", "TH", "TH"));

        for (Currency currency : Currency.getAvailableCurrencies().stream().sorted(Comparator.comparing(Currency::getDisplayName)).collect(Collectors.toList())) {
            if (currency.getDisplayName().equalsIgnoreCase("UYI")) {
                System.out.println(currency.getSymbol());
            }
//            System.out.println(currency.getDisplayName());
        }
    }

    public static void testLocale(Locale loc) {
        System.out.println();
        System.out.println("Locale: " +loc);
        showNumbers(loc);
        showCurrency(loc);
        showPercentage(loc);
    }

    private static void showPercentage(Locale loc) {
        NumberFormat format = NumberFormat.getPercentInstance(loc);
        System.out.println(format.format(.07));
    }

    private static void showCurrency(Locale loc) {
        Currency currency = Currency.getInstance(loc);
        NumberFormat format = NumberFormat.getCurrencyInstance(loc);

        System.out.println(currency.getDisplayName());
        System.out.println(format.format(987654.45));
    }

    private static void showNumbers(Locale loc) {
        Integer integer = 123456;
        Double aDouble = 12345.45;

        NumberFormat numberFormat = NumberFormat.getNumberInstance(loc);
        System.out.println(numberFormat.format(integer));
        System.out.println(numberFormat.format(aDouble));
    }
}
