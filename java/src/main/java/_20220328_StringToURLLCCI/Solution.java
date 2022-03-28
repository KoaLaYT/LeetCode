package _20220328_StringToURLLCCI;

public class Solution {

    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        char[] cc = S.toCharArray();

        for (int i = 0; i < length; i++) {
            char c = cc[i];
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
