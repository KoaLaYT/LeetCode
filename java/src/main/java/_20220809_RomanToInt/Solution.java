package _20220809_RomanToInt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Solution {

    private static Map<Character, Integer> table = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    private static Map<Character, List<Character>> subtractions = Map.of(
            'I', Arrays.asList('V', 'X'),
            'X', Arrays.asList('L', 'C'),
            'C', Arrays.asList('D', 'M')
    );

    public int romanToInt(String s) {
        char[] ss = s.toCharArray();

        int result = 0;
        char previousChar = '\0';
        for (int i = ss.length - 1; i >= 0; i--) {
            char symbol = ss[i];
            int value = table.get(symbol);

            if (subtractions.getOrDefault(symbol, Collections.emptyList()).contains(previousChar)) {
                result -= value;
            } else {
                result += value;
            }

            previousChar = symbol;
        }

        return result;
    }

}
