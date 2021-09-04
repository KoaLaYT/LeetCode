package _20210904_LengthOfLastWord;

/**
 * @author koalayt 2021-09-04
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            count = 0;
            while (i < s.length() && s.charAt(i) != ' ') {
                count++;
                i++;
            }
        }

        return count;
    }

}
