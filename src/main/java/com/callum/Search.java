package com.callum;

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
}