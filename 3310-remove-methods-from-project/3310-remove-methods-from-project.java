class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Build graph and indegree array
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        int[] indeg = new int[n];

        for (int[] it : invocations) {
            int i = it[0], j = it[1];
            g[i].add(j);
            indeg[j]++;
        }

        // BFS : Mark all suspicious methods
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        vis[k] = true;

        List<Integer> marked = new ArrayList<>();
        marked.add(k);

        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int node = q.poll();

                for (int adj : g[node]) {
                    if (!vis[adj]) {
                        q.offer(adj);
                        vis[adj] = true;
                        marked.add(adj);
                    }
                    // Remove internal edge contribution
                    indeg[adj]--;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Methods that are not suspicious
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                ans.add(i);
            }
        }

        // If any suspicious method still has an incoming edge,
        // removal is not possible.
        for (int i : marked) {
            if (indeg[i] >= 1) {
                ans.addAll(marked);
                break;
            }
        }

        return ans;
    }
}