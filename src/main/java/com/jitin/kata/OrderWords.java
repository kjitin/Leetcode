package com.jitin.kata;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderWords {

    public static void main(String[] args) {
        String input = "is2 Thi1s T4est 3a";
        System.out.println(orderSentenceLambda(input));
        System.out.println(orderSentenceQueue(input));
    }

    private static String orderSentenceQueue(String input) {
        if(input == null || input.isEmpty())
            return "";

        String[] words = input.split(" ");
        PriorityQueue<String> heap = new PriorityQueue<>(words.length, Comparator.comparingInt(OrderWords::extractDigit));

        for (String word: words) {
            heap.offer(word);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!heap.isEmpty()) {
            if (stringBuilder.length() >0 ) stringBuilder.append(' ');
            stringBuilder.append(heap.poll());
        }
        return stringBuilder.toString();
    }

    private static int extractDigit(String word) {
        for (char ch : word.toCharArray()) {
            if(Character.isDigit(ch)) {
                return ch - '0';
            }
        }
        throw new IllegalArgumentException("No Digit in word"+ word);
    }

    private static String orderSentenceLambda(String input) {
        if(input == null || input.isEmpty())
            return "";

        String[] words = input.split(" ");

        Arrays.sort(words, Comparator.comparingInt(w -> w.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .findFirst().orElse(0)
        ));

        return String.join(" ", words);
    }
}
