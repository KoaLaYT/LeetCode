package _20220904_MaximumProductOfWordLengths;

public class Solution {

  public int maxProduct(String[] words) {
    int[] masks = buildMask(words);

    int max = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if ((masks[i] & masks[j]) == 0) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }

    return max;
  }

  private int[] buildMask(String[] words) {
    int[] masks = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      masks[i] = buildMask(words[i]);
    }
    return masks;
  }

  private int buildMask(String word) {
    int mask = 0;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      mask |= 1 << (c - 'a');
    }
    return mask;
  }

}
