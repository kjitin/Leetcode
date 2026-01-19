package com.jitin.hackerrank;

import java.io.*;
import java.util.*;

public class FrequencyQueries {

    /**
     * Processes frequency queries and returns results for type 3 queries
     *
     * @param queries 2D array where queries[i][0] is operation type and queries[i][1] is the value
     * @return List of integers containing results for type 3 queries (1 or 0)
     */
    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> results = new ArrayList<>();

        // Map to store frequency of each element
        Map<Integer, Integer> elementFreq = new HashMap<>();

        // Map to store count of each frequency
        // freqCount[f] = number of elements that appear exactly f times
        // 1,5 2,6 3,2 1,10 1,10 1,6 2,5 3, 2
        Map<Integer, Integer> freqCount = new HashMap<>();

        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int value = query.get(1);

            switch (operation) {
                case 1: // Insert operation
                    insertElement(elementFreq, freqCount, value);
                    break;

                case 2: // Delete operation
                    deleteElement(elementFreq, freqCount, value);
                    break;

                case 3: // Check frequency operation
                    int result = checkFrequency(freqCount, value);
                    results.add(result);
                    break;
            }
        }

        return results;
    }

    /**
     * Inserts an element and updates both frequency maps
     */
    private static void insertElement(Map<Integer, Integer> elementFreq,
                                      Map<Integer, Integer> freqCount, int element) {
        // Get current frequency of the element (0 if not present)
        int currentFreq = elementFreq.getOrDefault(element, 0);

        // Decrease count of current frequency (if > 0)
        if (currentFreq > 0) {
            decreaseFreqCount(freqCount, currentFreq);
        }

        // Increase element frequency
        int newFreq = currentFreq + 1;
        elementFreq.put(element, newFreq);

        // Increase count of new frequency
        increaseFreqCount(freqCount, newFreq);
    }

    /**
     * Deletes an element and updates both frequency maps
     */
    private static void deleteElement(Map<Integer, Integer> elementFreq,
                                      Map<Integer, Integer> freqCount, int element) {
        // Check if element exists
        int currentFreq = elementFreq.getOrDefault(element, 0);

        if (currentFreq == 0) {
            return; // Element doesn't exist, nothing to delete
        }

        // Decrease count of current frequency
        decreaseFreqCount(freqCount, currentFreq);

        // Decrease element frequency
        int newFreq = currentFreq - 1;

        if (newFreq == 0) {
            // Remove element completely if frequency becomes 0
            elementFreq.remove(element);
        } else {
            // Update element frequency
            elementFreq.put(element, newFreq);
            // Increase count of new frequency
            increaseFreqCount(freqCount, newFreq);
        }
    }

    /**
     * Checks if any element has the specified frequency
     */
    private static int checkFrequency(Map<Integer, Integer> freqCount, int targetFreq) {
        int count = freqCount.getOrDefault(targetFreq, 0);
        return count > 0 ? 1 : 0;
    }

    /**
     * Helper method to increase frequency count
     */
    private static void increaseFreqCount(Map<Integer, Integer> freqCount, int freq) {
        freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
    }

    /**
     * Helper method to decrease frequency count
     */
    private static void decreaseFreqCount(Map<Integer, Integer> freqCount, int freq) {
        int count = freqCount.getOrDefault(freq, 0);
        if (count <= 1) {
            freqCount.remove(freq);
        } else {
            freqCount.put(freq, count - 1);
        }
    }

    /**
     * Alternative main method for testing
     */
    public static void main(String[] args) throws IOException {
        // Example usage
        List<List<Integer>> queries = new ArrayList<>();

        // Add sample queries
        queries.add(Arrays.asList(1, 5));  // Insert 5
        queries.add(Arrays.asList(1, 6));  // Insert 6
        queries.add(Arrays.asList(3, 2));  // Check if any element has frequency 2
        queries.add(Arrays.asList(1, 10)); // Insert 10
        queries.add(Arrays.asList(1, 10)); // Insert 10 again
        queries.add(Arrays.asList(1, 6));  // Insert 6 again
        queries.add(Arrays.asList(2, 5));  // Delete 5
        queries.add(Arrays.asList(3, 2));  // Check if any element has frequency 2

        List<Integer> results = freqQuery(queries);

        System.out.println("Results for type 3 queries:");
        for (int result : results) {
            System.out.println(result);
        }
    }
}
