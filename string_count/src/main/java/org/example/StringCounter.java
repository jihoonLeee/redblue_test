package org.example;

import java.util.HashMap;
import java.util.Map;

public class StringCounter {

    public static Map<Character, Integer> countCharacters(String sentence) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : sentence.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        return counts;
    }
}
