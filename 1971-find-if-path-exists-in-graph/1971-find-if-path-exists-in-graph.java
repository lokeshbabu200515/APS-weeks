import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges (undirected graph)
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Visited array
        boolean[] visited = new boolean[n];
        
        // DFS call
        return dfs(graph, visited, source, destination);
    }
    
    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int curr, int dest) {
        
        if (curr == dest) return true;
        
        visited[curr] = true;
        
        for (int neighbor : graph.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, neighbor, dest)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}