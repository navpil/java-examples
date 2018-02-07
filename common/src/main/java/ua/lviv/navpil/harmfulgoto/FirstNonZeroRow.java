package ua.lviv.navpil.harmfulgoto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FirstNonZeroRow {

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0,0,0,0}, {2, 2, 3, 4}};

        List<MyFunc> finders = new ArrayList<>();

        finders.add((ar, height, width) -> {
            outer:
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++)
                    if (ar[i][j] != 0)
                        continue outer;
                return i;
            }
            return -1;
        });

        finders.add((ar, height, width) -> {
            for (int i = 0; i < height; i++) {
                boolean zero = true;
                for (int j = 0; j < width && zero; j++)
                    if (ar[i][j] != 0)
                        zero = false;
                if (zero)
                    return i;
            }
            return -1;
        });

        finders.add((ar, height, width) -> {
            Predicate<int[]> isZeroRow = ((int[] row)-> {
                for(int x : row)
                    if (x != 0)
                        return false;
                return true;
            });
            for (int i = 0; i < height; i++)
                if (isZeroRow.test(ar[i]))
                    return i;
            return -1;
        });

        finders.add((ar, height, width) -> {
            for (int i = 0; i < ar.length; i++) {
                if (Arrays.stream(ar[i]).allMatch(value -> value == 0)) {
                    return i;
                }
            }
            return -1;
        });


        for (MyFunc finder : finders) {
            assert finder.findZeroRow(ints, 5, 4) == 3;
        }
    }

    interface MyFunc {
        int findZeroRow(int [][] ar, int height, int width);
    }



}
