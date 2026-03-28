package com.jitin.finalround;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(strings);
        List<List<String>> betteerResult = groupAnagramsBetter(strings);
        System.out.println(result);
    }

    private static List<List<String>> groupAnagramsBetter(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word: strings) {
            int[] freq = new int[26];
            for (char c: word.toCharArray()) {
                freq[c - 'a']++;
            }
            // 1#0#0#0#1#

            StringBuilder stringBuilder = new StringBuilder();
            for (int count: freq) {
                stringBuilder.append(count).append('#');
            }

            String key = stringBuilder.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);

        }
        return new ArrayList<>(map.values());

    }

    private static List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        for (String word: strings) {
            //get the char array so that it can be sorted
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(word);

        }
        return new ArrayList<>(map.values());
    }
}
