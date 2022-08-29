package _20220829_MinimumHeightTrees;

import java.util.*;

public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = buildGraph(n, edges);
        int[] parents = new int[n];
        int x = findLongestNode(0, n, parents, graph);
        int y = findLongestNode(x, n, parents, graph);

        List<Integer> paths = new ArrayList<>();
        int walk = y;
        while (walk != -1) {
            paths.add(walk);
            walk = parents[walk];
        }

        int len = paths.size();
        return len % 2 == 0
                ? Arrays.asList(paths.get(len / 2 - 1), paths.get(len / 2))
                : Collections.singletonList(paths.get(len / 2));
    }

    private List<List<Integer>> buildGraph(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    private int findLongestNode(int start, int n, int[] parents, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        Arrays.fill(parents, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        int last = start;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited[node] = true;
                last = node;
                for (int child : graph.get(node)) {
                    if (visited[child]) continue;
                    queue.add(child);
                    parents[child] = node;
                }
            }
        }

        return last;
    }

}
