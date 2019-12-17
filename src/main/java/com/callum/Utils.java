package com.callum;

import java.util.*;

public class Utils {

    // Merge and sort to non-primitive input arrays in descending order
    // with zeroo duplicates.
    public static int[] merge(Integer[] values1, Integer[] values2) {
        Set<Integer> mergedValues = new HashSet<>();

        if (values1 != null) {
            for (Integer i : values1) {
                if (i != null)
                    mergedValues.add(i);
            }
        }

        if (values2 != null) {
            for (Integer j : values2) {
                if (j != null)
                    mergedValues.add(j);
            }
        }

        if (mergedValues.isEmpty())
            return null;
        else
            return mergedValues
                .stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Number::intValue)
                .toArray();
    }
}
