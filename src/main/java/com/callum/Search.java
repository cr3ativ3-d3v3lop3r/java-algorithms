package com.callum;

import java.util.Arrays;
import java.util.List;

public class Search {

    @FunctionalInterface
    interface Loop {
        Boolean apply(Integer head, Integer last);
    }

    private static Loop loop;

    public Boolean binarySearch(List<Integer> xs, Integer target) {
        System.out.println("\n* Performing search for target " + target + " in list " + xs);

        loop = (head, last) -> {
            if (target > last) {
                System.out.println("Target is greater than the last element in the list, target is not found.");
                return false;
            } else if (target < head) {
                System.out.println("Target is less than the head of the list, target is not found.");
                return false;
            } else {
                Integer mid = xs.get((head + last) / 2);

                if (target == head) {
                    System.out.println("The target is equal to the head, target is found.");
                    return true;
                } else if (xs.get(mid) < target)
                    return loop.apply(mid, last);
                else if (xs.get(mid) > target)
                    return loop.apply(head, mid);
                else
                    System.out.println("Target is found, at element " + mid);
                return true;
            }
        };

        if (xs.size() < 1) {
            System.out.println("The list is empty, target is not found.");
            return false;
        } else return loop.apply(xs.get(0), xs.get(xs.size() - 1));
    }

    // Worst time O(log n) where n is the number of elements in the
    // collection.

    // Constant space O(1) meaning that the space taken is the same
    // for any number of elements in the collection.
    public static int binarySearch2(List<Integer> xs, Integer target) {
        int left = 0;
        int right = xs.size() - 1;

        System.out.println("xs.size = " + xs.size());
        System.out.println("left " + left);
        System.out.println("right " + right);

        while(left <= right) {
            int middle = left + (right - 1) / 2;

            if (xs.get(middle).equals(target))
                return middle;

            if (xs.get(middle) < target)
                left = middle + 1;
            else
                right = middle - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> xs = Arrays.asList(1, 2, 4, 5, 6, 9, 10, 12);

        System.out.println(binarySearch2(xs, 4));
    }
}