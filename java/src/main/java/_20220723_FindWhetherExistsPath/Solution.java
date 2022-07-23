package _20220723_FindWhetherExistsPath;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        boolean[] visited = new boolean[n];

        return dfs(buildGraph(n, graph), visited, start, target);
    }

    private List<List<Integer>> buildGraph(int n, int[][] graph) {
        List<List<Integer>> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            result.get(u).add(v);
        }

        return result;
    }

    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int start, int target) {
        if (visited[start]) {
            return false;
        }

        if (start == target) {
            return true;
        }

        visited[start] = true;

        for (int v : graph.get(start)) {
            boolean reached = dfs(graph, visited, v, target);
            if (reached) {
                return true;
            }
        }

        return false;
    }

}
