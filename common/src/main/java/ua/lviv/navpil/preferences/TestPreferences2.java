package ua.lviv.navpil.preferences;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class TestPreferences2 {

    public static void main(String[] args) {

        Preferences preferences = Preferences.userNodeForPackage(TestPreferences2.class);
        doWithPreferences(preferences);

        TestPreferences2 testPreferences = new TestPreferences2();
        testPreferences.doSomething();
    }

    private void doSomething() {
        Preferences preferences = Preferences.userNodeForPackage(TestPreferences2.class);
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
