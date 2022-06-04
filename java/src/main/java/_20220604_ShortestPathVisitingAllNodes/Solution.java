package _20220604_ShortestPathVisitingAllNodes;

import java.util.*;

public class Solution {
    public int shortestPathLength(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        // 0..0 000000000000 0000
        // |    |            |
        // |    |            +-> 4 bits as current node
        // |    +-> 12 bits mask as visited paths
        // +-> rest 16 bits as current path length
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            int info = (1 << (i + 4)) | i;
            queue.add(info);
            visited.add(info);
        }

        while (!queue.isEmpty()) {
            int info = queue.poll();
            int currLen = pathLen(info);
            if (isAllVisited(info, graph.length)) {
                return currLen;
            }
            int node = currNode(info);
            for (int nextNode : graph[node]) {
                int visitedInfo = visitedInfo(info, nextNode);
                if (visited.contains(visitedInfo)) continue;
                int newInfo = visitedInfo | ((currLen + 1) << 16);
                visited.add(visitedInfo);
                queue.add(newInfo);
            }
        }

        return -1;
    }

    private static int visitedInfo(int info, int nextNode) {
        return nextNode | (info & 0xFFF0) | (1 << (nextNode + 4));
    }

    private static int pathLen(int info) {
        return info >> 16;
    }

    private static int currNode(int info) {
        return info & 0xF;
    }

    private static boolean isAllVisited(int info, int total) {
        return Integer.bitCount(info & 0xFFF0) == total;
    }

}
