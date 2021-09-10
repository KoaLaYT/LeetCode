package _20210910_TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koalayt 2021-09-10
 */
public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        LineScanner lineScanner = new LineScanner(maxWidth);

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            index = lineScanner.scan(words, index);
            result.add(lineScanner.justifyLine());
        }

        return result;
    }

    static class LineScanner {
        private final int maxWidth;
        private final List<String> scannedWords;
        private int wordLength;
        private boolean isLastLine;

        LineScanner(int maxWidth) {
            this.maxWidth = maxWidth;
            this.scannedWords = new ArrayList<>();
            this.wordLength = 0;
            this.isLastLine = false;
        }

        // scan words into lines
        int scan(String[] words, int startIndex) {
            reset();
            int length = 0;
            while (startIndex < words.length) {
                String word = words[startIndex];
                if (length + word.length() + scannedWords.size() > maxWidth) {
                    break;
                } else {
                    length += word.length();
                    scannedWords.add(word);
                    wordLength += word.length();
                    startIndex++;
                }
            }
            isLastLine = startIndex >= words.length;
            return startIndex;
        }

        void reset() {
            wordLength = 0;
            scannedWords.clear();
        }

        String justifyLine() {
            if (isLastLine) {
                return leftJustify();
            }
            return evenJustify();
        }

        String leftJustify() {
            StringBuilder builder = new StringBuilder();
            int length = 0;
            for (String word : scannedWords) {
                builder.append(word);
                length += word.length();
                if (length < maxWidth) {
                    builder.append(' ');
                    length += 1;
                }
            }
            appendSpace(builder, maxWidth - length);
            return builder.toString();
        }

        String evenJustify() {
            StringBuilder builder = new StringBuilder();
            int leftSpace = getSpaceSize();
            for (int i = 0; i < scannedWords.size(); i++) {
                String word = scannedWords.get(i);
                builder.append(word);
                if (leftSpace > 0) {
                    int needSpace = needSpace(leftSpace, i);
                    appendSpace(builder, needSpace);
                    leftSpace -= needSpace;
                }
            }
            return builder.toString();
        }

        int getSpaceSize() {
            return maxWidth - wordLength;
        }

        void appendSpace(StringBuilder builder, int num) {
            while (num > 0) {
                builder.append(' ');
                num -= 1;
            }
        }

        int needSpace(int spaceSize, int index) {
            if (scannedWords.size() == 1) {
                return spaceSize;
            }
            return (int) Math.ceil(((double) spaceSize) / (scannedWords.size() - 1 - index));
        }
    }

}
