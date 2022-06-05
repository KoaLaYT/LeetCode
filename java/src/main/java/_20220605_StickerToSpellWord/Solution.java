package _20220605_StickerToSpellWord;

import java.util.Arrays;

public class Solution {

    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -2);
        memo[0] = 0;
        int result = minSticker(stickers, target, (1 << n) - 1, memo);
        return result == n + 1 ? -1 : result;
    }

    private int minSticker(String[] stickers, String target, int mask, int[] memo) {
        if (memo[mask] == -2) {

            int res = target.length() + 1;
            for (String sticker : stickers) {
                int[] cnt = new int[26];
                for (int i = 0; i < sticker.length(); i++) {
                    cnt[sticker.charAt(i) - 'a'] += 1;
                }
                int left = mask;
                for (int i = 0; i < target.length(); i++) {
                    if (((left >> i) & 1) == 0) continue;
                    int charIndex = target.charAt(i) - 'a';
                    if (cnt[charIndex] > 0) {
                        cnt[charIndex] -= 1;
                        left &= ~(1 << i);
                    }
                }
                if (left != mask) {
                    res = Math.min(res, minSticker(stickers, target, left, memo) + 1);
                }
            }

            memo[mask] = res;
        }

        return memo[mask];
    }

}
