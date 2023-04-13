package ua.lviv.navpil.collections.real;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Maps {

    private Map<String, TimeScheduleImpl> timeSchedules;

    protected String[] doReadUsersAll(JsonArray objUsers) {
        // read all users into map
        // get new map
        Map<String, TimeScheduleImpl> newMap = this.ensureMapSize(objUsers.getCount());

        // loop and create time schedule objects
        String[] result = new String[12];
        int k = 0;
        for (int i = 0; i < objUsers.getCount(); i++) {
            String id = objUsers.get(i).get("ID").getStr();
            result = ArrayUtil.ensureSize(result, String.class, k + 1, 12);
            result[k++] = id;

            if (newMap.containsKey(id)) {
                TimeScheduleImpl knownTim = newMap.get(id);
                /*
                snipped code - update existing time schedule
                 */
            } else {
                TimeScheduleImpl cal = new TimeScheduleImpl(objUsers.get(i));
                newMap.put(id, cal);
            }
        }

        // move pointer
        this.timeSchedules = newMap;
        // return
        return Arrays.copyOfRange(result, 0, k);
    }


    protected Map<String, TimeScheduleImpl> ensureMapSize(int addSize) {
        // calc size of map
        int newMinSize = CollectionUtils.calculateMapSize((null == this.timeSchedules ? 0 : this.timeSchedules.size()) + addSize);
        HashMap<String, TimeScheduleImpl> newMap = new HashMap<String, TimeScheduleImpl>(newMinSize);

        // handle map
        if (null != this.timeSchedules) {
            // move existing entries
            for (String key : this.timeSchedules.keySet()) {
                newMap.put(key, this.timeSchedules.get(key));
            }
        }

        // return
        return newMap;
    }

    private static class ArrayUtil {

        /**
         * Verifies that the supplied array has the supplied length. If not a new
         * array is created which is "increment" larger.
         *
         * @param elements
         * @param length Required length
         * @param increment The number of elements to increment with
         * @return
         */
        public static <T> T[] ensureSize(T[] elements, Class c, int length, int increment) {
            if (null == elements) return elements;
            if (elements.length <= length) {
                // extend
                int newLength = Math.max(elements.length + increment, length);
                T[] newElements = (T[]) Array.newInstance(c, newLength);
                System.arraycopy(elements, 0, newElements, 0, elements.length);
                return newElements;
            } else {
                return elements;
            }
        }
    }

    private static class CollectionUtils {

        public static int calculateMapSize(int size) {
            int newMinSize = (int)((float)size / 0.75f);
            newMinSize = roundNextPow2(newMinSize);
            return newMinSize;
        }

        /**
         * Rounds the supplied number to the next power of 2.
         *
         * @param x
         * @return
         */
        private static int roundNextPow2(int x) {
            x--;
            x |= x >> 1;
            x |= x >> 2;
            x |= x >> 4;
            x |= x >> 8;
            x |= x >> 16;
            x++;
            return x;
        }
    }

    private class TimeScheduleImpl {
        public TimeScheduleImpl(JsonObject json) {

        }

        public void updateUser(JsonObject json) {

        }
    }

    private class JsonArray {
        private int count;

        public int getCount() {
            return count;
        }

        public JsonObject get(int i) {
            return null;
        }
    }

    private class JsonObject {
        public String getStr() {
            return null;
        }

        public JsonObject get(String id) {
            return null;
        }


    }
}
