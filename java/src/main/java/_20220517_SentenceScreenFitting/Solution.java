package _20220517_SentenceScreenFitting;

public class Solution {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int len = sentence.length;
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            int left = cols;
            int p = i;
            int count = 0;
            while (left - sentence[p].length() >= 0) {
                left -= sentence[p].length() + 1;
                p++;
                if (p == len) {
                    p = 0;
                    count += 1;
                }
            }
            dp[i] = 100 * count + p;
        }

        int count = 0;
        for (int row = 0, index = 0; row < rows; row++) {
            int data = dp[index];

            count += data / 100;
            index = data % 100;
        }

        return count;
    }

}
