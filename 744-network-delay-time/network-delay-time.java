class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int[] t : times)
            adj[t[0]].add(new int[]{t[1], t[2]});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], time = cur[1];

            if (time > dist[node]) continue;

            for (int[] next : adj[node]) {
                int v = next[0], w = next[1];

                if (dist[v] > time + w) {
                    dist[v] = time + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }
}