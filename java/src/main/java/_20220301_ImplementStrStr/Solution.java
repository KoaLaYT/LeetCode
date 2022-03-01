package _20220301_ImplementStrStr;

public class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty()) {
            return -1;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean allEqual = true;

                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        allEqual = false;
                        break;
                    }
                }

                if (allEqual) {
                    return i;
                }
            }
        }

        return -1;
    }

}
