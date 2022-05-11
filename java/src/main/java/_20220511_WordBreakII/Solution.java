package _20220511_WordBreakII;

import java.util.*;

public class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        List<List<String>> wordsList = backtrace(s, new HashSet<>(wordDict), 0, memo);
        List<String> result = new LinkedList<>();
        for (List<String> words : wordsList) {
            String word = String.join(" ", words);
            result.add(word);
        }
        return result;
    }

    private List<List<String>> backtrace(
            String s,
            Set<String> wordDict,
            int index,
            Map<Integer, List<List<String>>> memo
    ) {
        if (!memo.containsKey(index)) {
            List<List<String>> result = new LinkedList<>();
            if (index == s.length()) {
                result.add(new LinkedList<>());
            }
            for (int end = index + 1; end <= s.length(); end++) {
                String word = s.substring(index, end);
                if (wordDict.contains(word)) {
                    List<List<String>> left = backtrace(s, wordDict, end, memo);
                    for (List<String> words : left) {
                        LinkedList<String> wordBreak = new LinkedList<>(words);
                        wordBreak.offerFirst(word);
                        result.add(wordBreak);
                    }
                }
            }
            memo.put(index, result);
        }
        return memo.get(index);
    }

}
