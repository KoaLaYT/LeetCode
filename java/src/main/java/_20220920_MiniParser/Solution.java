package _20220920_MiniParser;

public class Solution {

    public NestedInteger deserialize(String s) {
        return deserialize(s, 0).ni;
    }

    private ParseRes deserialize(String s, int index) {
        if (s.charAt(index) == '[') {
            return deserializeList(s, index);
        } else {
            return deserializeInt(s, index);
        }
    }

    // start from '['
    private ParseRes deserializeList(String s, int index) {
        NestedInteger result = new NestedInteger();
        index += 1;

        while (index < s.length() && s.charAt(index) != ']') {
            if (s.charAt(index) == ',') {
                index += 1;
            }

            ParseRes pr = deserialize(s, index);
            result.add(pr.ni);
            index = pr.currentIndex;
        }

        return new ParseRes(result, index + 1);
    }

    private ParseRes deserializeInt(String s, int index) {
        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
            index += 1;
        }

        int value = 0;
        while (index < s.length() &&
                s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            int digit = s.charAt(index) - '0';
            value = value * 10 + digit;
            index += 1;
        }

        return new ParseRes(new NestedInteger(value * sign), index);
    }

    private static class ParseRes {
        NestedInteger ni;
        int currentIndex;

        ParseRes(NestedInteger ni, int currentIndex) {
            this.ni = ni;
            this.currentIndex = currentIndex;
        }
    }

}
