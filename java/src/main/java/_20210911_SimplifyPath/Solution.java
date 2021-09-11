package _20210911_SimplifyPath;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author koalayt 2021-09-11
 */
public class Solution {

    private static final String DOT = ".";
    private static final String PARENT = "..";
    private static final String SLASH = "/";

    public String simplifyPath(String path) {
        Deque<String> dirs = new LinkedList<>();
        StringBuilder builder = new StringBuilder();

        for (String dir : path.split(SLASH)) {
            if (dir.equals(DOT)) {
                continue;
            }
            if (dir.equals(PARENT)) {
                if (!dirs.isEmpty()) {
                    dirs.removeLast();
                }
            } else if (!dir.isEmpty()) {
                dirs.addLast(dir);
            }
        }

        while (!dirs.isEmpty()) {
            builder.append("/");
            builder.append(dirs.removeFirst());
        }

        return builder.length() > 0 ? builder.toString() : "/";
    }

}
