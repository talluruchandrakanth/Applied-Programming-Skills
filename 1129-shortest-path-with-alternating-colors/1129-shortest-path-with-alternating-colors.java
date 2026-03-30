import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : redEdges) graph[e[0]].add(new int[]{e[1], 0});
        for (int[] e : blueEdges) graph[e[0]].add(new int[]{e[1], 1});

        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});
        dist[0][0] = dist[0][1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], color = cur[1];

            for (int[] nei : graph[node]) {
                int next = nei[0], nextColor = nei[1];
                if (nextColor != color && dist[next][nextColor] == Integer.MAX_VALUE) {
                    dist[next][nextColor] = dist[node][color] + 1;
                    q.offer(new int[]{next, nextColor});
                }
            }
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int d = Math.min(dist[i][0], dist[i][1]);
            res[i] = (d == Integer.MAX_VALUE) ? -1 : d;
        }

        return res;
    }
}