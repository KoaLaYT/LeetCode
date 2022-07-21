package _20220721_IsConnectGraph;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean isConnectGraph(int n, int[][] e) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : e) {
            int p = edge[0];
            int q = edge[1];
            graph.get(p).add(q);
            graph.get(q).add(p);
        }

        boolean[] visited = new boolean[n];

        dfs(0, graph, visited);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int v, List<List<Integer>> graph, boolean[] visited) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int s : graph.get(v)) {
            dfs(s, graph, visited);
        }
    }

}
