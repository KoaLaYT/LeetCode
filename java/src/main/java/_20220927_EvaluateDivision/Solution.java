package _20220927_EvaluateDivision;

import java.util.*;

public class Solution {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries
    ) {
        Map<String, List<Edge>> graph = buildGraph(equations, values);

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Set<String> visited = new HashSet<>();
            result[i] = calcEquation(graph, visited, 1.0, query.get(0), query.get(1));
        }

        return result;
    }

    private Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String to = equation.get(1);
            double value = values[i];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(new Edge(from, to, value));
            graph.get(to).add(new Edge(to, from, 1 / value));
        }

        return graph;
    }

    private double calcEquation(Map<String, List<Edge>> graph, Set<String> visited, double value, String begin, String end) {
        List<Edge> neighbours = graph.get(begin);
        if (neighbours == null) {
            return -1.0;
        }

        if (begin.equals(end)) {
            return value;
        }

        visited.add(begin);
        for (Edge edge : neighbours) {
            if (visited.contains(edge.to)) continue;
            double result = calcEquation(graph, visited, value * edge.value, edge.to, end);
            if (result != -1.0) {
                return result;
            }
        }
        visited.remove(begin);

        return -1.0;
    }

    private static class Edge {
        String from;
        String to;
        double value;

        Edge(String from, String to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }

    }

}
