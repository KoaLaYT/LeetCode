package _20220811_GroupAnagrams;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for (String str : strs) {
            int[] cnt = new int[26];
            for (char c : str.toCharArray()) {
                cnt[c - 'a'] += 1;
            }

            String key = compactKey(cnt);
            List<String> comb = result.computeIfAbsent(key, k -> new ArrayList<>());
            comb.add(str);
        }

        return new ArrayList<>(result.values());
    }

    private String compactKey(int[] cnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                sb.append((char) ('a' + i));
                sb.append(cnt[i]);
            }
        }
        return sb.toString();
    }

}
