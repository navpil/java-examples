package ua.lviv.navpil.preferences;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class TestPreferences {

    public static void main(String[] args) throws IOException, BackingStoreException {

        Preferences preferences = Preferences.userNodeForPackage(TestPreferences.class);
        doWithPreferences(preferences);

        TestPreferences testPreferences = new TestPreferences();
        testPreferences.doSomething();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        preferences.exportSubtree(new BufferedOutputStream(out));

        String asdfasdf = new String(out.toByteArray());

        System.out.println(asdfasdf);


    }

    private void doSomething() {
        Preferences preferences = Preferences.userNodeForPackage(TestPreferences.class);
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
