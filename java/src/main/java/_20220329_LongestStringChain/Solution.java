package _20220329_LongestStringChain;

import java.util.*;

public class Solution {

    public int longestStrChain(String[] words) {
        return treeMap(words);
    }

    public int treeMap(String[] words) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        Map<String, Integer> dp = new HashMap<>();

        for (String word : words) {
            int len = word.length();
            map.computeIfAbsent(len, v -> new ArrayList<>());
            map.get(len).add(word);
            dp.put(word, 1);
        }

        int max = 1;

        for (Integer len : map.keySet()) {
            List<String> candidates = map.get(len - 1);
            if (candidates == null || candidates.isEmpty()) {
                continue;
            }
            for (String a : map.get(len)) {
                for (String b : candidates) {
                    if (isPredecessor(a, b)) {
                        int v = Math.max(dp.get(a), dp.get(b) + 1);
                        dp.put(a, v);
                        max = Math.max(max, v);
                    }
                }
            }
        }

        return max;
    }

    private boolean isPredecessor(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < len1 && j < len2) {
            if (a.charAt(i) != b.charAt(j)) {
                if (k == 1) {
                    return false;
                }
                k++;
                i++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    public int hashMemo(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> strings = new HashMap<>();
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            strings.put(word, i);
            if (word.length() > 1) {
                for (int j = 0; j < word.length(); j++) {
                    String str = word.substring(0, j) + word.substring(j + 1);
                    Integer pos = strings.get(str);
                    if (pos != null) {
                        dp[i] = Math.max(dp[i], dp[pos] + 1);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }


}
