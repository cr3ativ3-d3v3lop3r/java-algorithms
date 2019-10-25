package com.callum;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@FunctionalInterface
interface Construct {
    List<Integer> apply(Integer size);
}

public class SearchSpec {

    List<Integer> list = new ArrayList<>();

    private Construct constructList = size -> {
        for(int i = 1; i < size + 1; i++) {
            list.add(i);
        }

        return list;
    };

    @Test
    public void binarySearchSpec1() {
        assertTrue(new Search().binarySearch(constructList.apply(10), 5),
                "A binary search method should search a sorted list of 10 elements for a target value 5 in chunks.");
    }

    @Test
    public void binarySearchSpec2() {
        assertTrue(new Search().binarySearch(constructList.apply(10), 10),
                "A binary search method should search a sorted list of 10 elements for a target value 10 in chunks.");
    }

    @Test
    public void binarySearchSpec3() {
        assertTrue(new Search().binarySearch(constructList.apply(10), 1),
                "A binary search method should search a sorted list of 10 elements for a target value 1 in chunks.");
    }

    @Test
    public void binarySearchSpec4() {
        assertFalse(new Search().binarySearch(constructList.apply(0), 0),
                "A binary search method should search an empty list of 0 elements.");
    }

    @Test
    public void binarySearchSpec5() {
        assertFalse(new Search().binarySearch(constructList.apply(10), -1),
                "A binary search method should search an sorted list of 10 elements for a target value -1 in chunks.");
    }

    @Test
    public void binarySearchSpec6() {
        assertFalse(new Search().binarySearch(constructList.apply(10), 11),
                "A binary search method should search an sorted list of 10 elements for a target value 11 in chunks.");
    }
}