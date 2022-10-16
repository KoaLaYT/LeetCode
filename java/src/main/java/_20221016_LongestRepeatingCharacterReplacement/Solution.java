package _20221016_LongestRepeatingCharacterReplacement;

public class Solution {

    public int characterReplacement(String s, int k) {
        if (s.length() == 1) {
            return 1;
        }

        char[] ss = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int[] freq = new int[26];

        while (right < ss.length) {
            freq[ss[right] - 'A'] += 1;
            maxCount = Math.max(maxCount, freq[ss[right] - 'A']);

            if (right - left + 1 > maxCount + k) {
                freq[ss[left++] - 'A'] -= 1;
            }

            right += 1;
        }

        return right - left;
    }

}
