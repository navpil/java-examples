package ua.lviv.navpil.preferences.subpackage;

import java.util.prefs.BackingStoreException;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.Preferences;

public class TestPreferences3 {

    public static void main(String[] args) {

        Preferences preferences = Preferences.userRoot().node("ua/lviv/navpil/preferences");
        preferences.addPreferenceChangeListener((PreferenceChangeEvent evt) -> System.out.println(evt.getNode() + " ( " +  evt + ")"));
        preferences.putInt("hello", 324);
        doWithPreferences(preferences);

        TestPreferences3 testPreferences = new TestPreferences3();
        testPreferences.doSomething();
    }

    private void doSomething() {
        Preferences preferences = Preferences.userNodeForPackage(TestPreferences3.class);
        doWithPreferences(preferences);
    }

    private static void doWithPreferences(Preferences preferences) {
        System.out.println(preferences.getInt("num_rows", 40));
        System.out.println(preferences.getInt("num_cols", 80));

        try {
            for (String s : preferences.keys()) {
                System.out.println(s + ": " + preferences.get(s, null));
            }
        } catch (BackingStoreException e) {
            System.out.println("Can't access store");
        }
    }

}
