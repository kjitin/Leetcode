package com.jitin.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeometricTriplets {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 4, 16, 64);
        System.out.println(countTriplets(integerList, 4));
    }

    /**
     * Finds the number of triplets (i, j, k) where i < j < k and
     * arr[i], arr[j], arr[k] form a geometric progression with ratio r
     *
     * @param arr The input array
     * @param r The common ratio
     * @return Number of valid triplets
     */
    public static long countTriplets(List<Integer> arr, long r) {
        if (arr == null || arr.size() < 3) {
            return 0;
        }

        // Handle special case where r = 1
        if (r == 1) {
            return countTripletsForRatioOne(arr);
        }

        // Map to store frequency of elements that can be the first element
        // of a triplet ending at current position
        Map<Long, Long> leftMap = new HashMap<>();

        // Map to store frequency of elements that can be the third element
        // of a triplet starting at current position
        Map<Long, Long> rightMap = new HashMap<>();

        // Initialize rightMap with all elements except the first two
        for (int i = 2; i < arr.size(); i++) {
            rightMap.put((long) arr.get(i), rightMap.getOrDefault((long) arr.get(i), 0L) + 1);
        }

        long totalTriplets = 0;

        // Iterate through each potential middle element
        for (int j = 1; j < arr.size() - 1; j++) {
            long currentElement = arr.get(j);

            // Add the element just before current position to leftMap
            long leftElement = arr.get(j - 1);
            leftMap.put(leftElement, leftMap.getOrDefault(leftElement, 0L) + 1);

            // Remove the element just after current position from rightMap
            long rightElement = arr.get(j + 1);
            rightMap.put(rightElement, rightMap.getOrDefault(rightElement, 0L) - 1);
            if (rightMap.get(rightElement) == 0) {
                rightMap.remove(rightElement);
            }

            // Check if current element can be middle of a GP
            // First element should be currentElement / r
            // Third element should be currentElement * r

            long firstElement = 0;
            long thirdElement = 0;

            // Check for potential overflow and valid division
            if (currentElement % r == 0) {
                firstElement = currentElement / r;
            } else {
                continue; // currentElement cannot be middle of GP with this ratio
            }

            // Check for potential overflow in multiplication
            if (r != 0 && currentElement <= Long.MAX_VALUE / r) {
                thirdElement = currentElement * r;
            } else {
                continue; // Overflow would occur
            }

            // Count triplets with current element as middle
            long leftCount = leftMap.getOrDefault(firstElement, 0L);
            long rightCount = rightMap.getOrDefault(thirdElement, 0L);

            totalTriplets += leftCount * rightCount;
        }

        return totalTriplets;
    }

    /**
     * Special case handler for when r = 1 (all elements in triplet are equal)
     */
    private static long countTripletsForRatioOne(List<Integer> arr) {
        Map<Integer, Long> frequency = new HashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            frequency.put(num, frequency.getOrDefault(num, 0L) + 1);
        }

        long totalTriplets = 0;

        // For each unique element, calculate C(count, 3) = count * (count-1) * (count-2) / 6
        for (long count : frequency.values()) {
            if (count >= 3) {
                totalTriplets += (count * (count - 1) * (count - 2)) / 6;
            }
        }

        return totalTriplets;
    }
}
