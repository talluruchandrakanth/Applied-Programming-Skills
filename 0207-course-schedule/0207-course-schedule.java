import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && hasCycle(adj, state, i)) return false;
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] state, int node) {
        state[node] = 1;

        for (int nei : adj.get(node)) {
            if (state[nei] == 1) return true;
            if (state[nei] == 0 && hasCycle(adj, state, nei)) return true;
        }

        state[node] = 2;
        return false;
    }
}