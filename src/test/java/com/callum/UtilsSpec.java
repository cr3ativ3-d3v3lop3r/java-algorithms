package com.callum;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UtilsSpec {

    @Test
    public void testSize() {
        int[] actualResult = Utils.merge(new Integer[] { 1, 11, 2, 3 }, new Integer[] { 5, 3, 1 });
        int[] expectedResult = new int[]{ 11, 5, 3, 2, 1 };

        assertEquals(actualResult.length, expectedResult.length);
    }

    @Test
    public void testSort() {
        int[] actualResult = Utils.merge(new Integer[] { 1, 2, 3 }, new Integer[] {5, 3, 1});

        for(int i = 1; i < actualResult.length; i++) {
            if (actualResult[i] > actualResult[i-1])
                throw new RuntimeException("index " + i + " is > than index " + (i - 1));
            else
                assertTrue(actualResult[i] < actualResult[i - 1]);
        }
    }

    @Test
    public void testBothNullPrimitiveInput() {
        assertNull(Utils.merge(null, null));
    }

    @Test
    public void testOneNullInput() {
        int[] actualResult = Utils.merge(null, new Integer[] { 1, 11, 2, 3 });

        assertEquals(4, actualResult.length);

        for(int i = 1; i < actualResult.length; i++) {
            if (actualResult[i] > actualResult[i-1])
                throw new RuntimeException("index " + i + " is > than index " + (i - 1));
            else
                assertTrue(actualResult[i] < actualResult[i - 1]);
        }
    }

    @Test
    public void testBothNullInput() {
        int[] actualResult = Utils.merge(new Integer[] { null, null }, new Integer[] { null, null, null, null });

        assertNull(actualResult);
    }
}