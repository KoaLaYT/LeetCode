package _20220921_LongestAbsoluteFilePath;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public int lengthLongestPath(String input) {
        Deque<Integer> dirs = new ArrayDeque<>();
        int index = 0;
        int totalLength = 0;
        int maxLength = 0;
        int prevLevel = -1;

        while (index < input.length()) {
            int level = parseLevel(input, index);
            while (level <= prevLevel) {
                int len = dirs.pop();
                totalLength -= len + 1;
                prevLevel -= 1;
            }
            prevLevel = level;
            index += level;

            ParsePathRes parsePathRes = parsePath(input, index);
            index = parsePathRes.currentIndex;
            if (parsePathRes.isFile) {
                maxLength = Math.max(maxLength, totalLength + parsePathRes.pathLen);
            }
            dirs.push(parsePathRes.pathLen);
            totalLength += parsePathRes.pathLen + 1;
        }

        return maxLength;
    }

    private static int parseLevel(String input, int index) {
        int level = 0;
        while (index < input.length() && input.charAt(index) == '\t') {
            index += 1;
            level += 1;
        }
        return level;
    }

    private static ParsePathRes parsePath(String input, int index) {
        int pathLen = 0;
        boolean isFile = false;

        while (index < input.length() && input.charAt(index) != '\n') {
            if (input.charAt(index) == '.') {
                isFile = true;
            }
            index += 1;
            pathLen += 1;
        }

        return new ParsePathRes(index + 1, isFile, pathLen);
    }

    private static class ParsePathRes {
        int currentIndex;
        boolean isFile;
        int pathLen;

        ParsePathRes(int currentIndex, boolean isFile, int pathLen) {
            this.currentIndex = currentIndex;
            this.isFile = isFile;
            this.pathLen = pathLen;
        }
    }

}
