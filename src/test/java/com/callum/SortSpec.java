package com.callum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SortSpec {

    private List<Integer> constructList(Integer size) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i  = 0; i < size; i++) {
            list.add(random.nextInt(1001));
        }

        return list;
    }

    @Test
    @DisplayName("A bubble sort method should compare adjacent elements and sort in ascending order")
    public void bubbleSortSpec1() {
        List<Integer> input = constructList(10);
        List<Integer> output = input.stream().sorted().collect(Collectors.toList());

        assertThat(new Sort().bubbleSort(input), is(output));
    }

    @Test
    @DisplayName("A quick sort method should compare adjacent partitions based upon a pivot point and sort recursively")
    public void quickSortSpec1() {
        List<Integer> input = constructList(1000000);
        List<Integer> output = input.stream().sorted().collect(Collectors.toList());

        assertThat(new Sort().quickSort(input), is(output));
    }
}
