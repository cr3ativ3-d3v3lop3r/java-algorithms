package com.callum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface Loop {
    List<Integer> apply(List<Integer> xs, Boolean swapped, Integer accumulator);
}

@FunctionalInterface
interface QuickLoop {
    List<Integer> apply(List<Integer> xs);
}

public class Sort {

    private static Loop loop;
    private static QuickLoop quickLoop;

    public List<Integer> bubbleSort(List<Integer> xs) {
        System.out.println("\n* Performing bubble sort algorithm on list " + xs);

        loop = (list, swapped, accumulator) -> {
            System.out.println("\nList is now " + list);

            if (accumulator == list.size() - 1 && swapped) {
                System.out.println("\n* Traversed the entire list and swapped elements, the list may not be sorted!");
                return loop.apply(list, false, 0);

            } else if (accumulator == list.size() - 1 && !swapped) {
                System.out.println("\n* Traversed the entire list and not swapped elements, the list is sorted!");
                return list;

            } else if (list.get(accumulator) > list.get(accumulator + 1)) {
                System.out.println("\n* [" + list.get(accumulator) + "] > [" + list.get(accumulator + 1) + "] swapping elements...");

                Integer tmp = list.get(accumulator);

                list.set(accumulator, list.get(accumulator + 1));
                list.set(accumulator + 1, tmp);
                return loop.apply(list, true, accumulator + 1);

            } else if (list.get(accumulator) < list.get(accumulator + 1)) {
                System.out.println("\n* [" + list.get(accumulator) + "] < [" + list.get(accumulator + 1) + "] moving to next element...");
                return loop.apply(list, swapped, accumulator + 1);

            } else {
                System.out.println("\n* Traversed the entire list and not swapped elements, the list is sorted!");
                return list;
            }
        };

        if (xs.size() < 1) {
            System.out.println("\n* The list is empty, no sort is necessary!");
            return xs;
        } else
            return loop.apply(xs, false, 0);
    }

    public List<Integer> quickSort(List<Integer> xs) {
        System.out.println("\n* Performing quick sort algorithm on list " + xs);

        quickLoop = list -> {
            if (list.size() == 0)
                return list;

            List<Integer> leftPartition = new ArrayList<>();
            List<Integer> rightPartition = new ArrayList<>();
            List<Integer> pivotPartition = new ArrayList<>();

            Integer pivot = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < pivot)
                    leftPartition.add(list.get(i));
                else
                    rightPartition.add(list.get(i));
            }

            pivotPartition.add(pivot);

            return Stream.of(quickLoop.apply(leftPartition), pivotPartition, quickLoop.apply(rightPartition))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        };

        return quickLoop.apply(xs);
    }

    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSort2(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort2(arr, low, pi -1);
            quickSort2(arr, pi + 1, high);
        }
    }
}