class Solution {
    static class Pair {
        long cost;
        String node;

        Pair(long cost, String node) {
            this.cost = cost;
            this.node = node;
        }
    }

    long BIG_VALUE = (long) 1e10;

    // Graph: original -> list of (changed, cost)
    Map<String, List<Pair>> adj = new HashMap<>();

    long[] dpMemo;
    String sourceStr, targetStr;

    TreeSet<Integer> validLengths = new TreeSet<>();

    long dijkstra(String start, String end) {

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));

        Map<String, Long> dist = new HashMap<>();
        dist.put(start, 0L);
        pq.offer(new Pair(0, start));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            long currCost = cur.cost;
            String node = cur.node;

            if (node.equals(end))
                return currCost;   // shortest found

            if (!adj.containsKey(node))
                continue;

            for (Pair edge : adj.get(node)) {
                String next = edge.node;
                long newCost = currCost + edge.cost;

                if (!dist.containsKey(next) || newCost < dist.get(next)) {
                    dist.put(next, newCost);
                    pq.offer(new Pair(newCost, next));
                }
            }
        }

        return BIG_VALUE;
    }

    public long solve(int idx) {

        if (idx >= sourceStr.length())
            return 0;

        if (dpMemo[idx] != -1)
            return dpMemo[idx];

        long minCost = BIG_VALUE;

        //  characters same
        if (sourceStr.charAt(idx) == targetStr.charAt(idx)) {
            minCost = solve(idx + 1);
        }

        // substring conversions
        for (int len : validLengths) {

            if (idx + len > sourceStr.length())
                break;

            String srcSub = sourceStr.substring(idx, idx + len);
            String tgtSub = targetStr.substring(idx, idx + len);

            if (!adj.containsKey(srcSub))
                continue;

            long pathCost = dijkstra(srcSub, tgtSub);
            if (pathCost == BIG_VALUE)
                continue;

            minCost = Math.min(minCost, pathCost + solve(idx + len));
        }

        dpMemo[idx] = minCost;
        return minCost;
    }

    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost) {

        sourceStr = source;
        targetStr = target;

        dpMemo = new long[10001];
        Arrays.fill(dpMemo, -1);

        // build graph
       for (int i = 0; i < original.length; i++) {

            String from = original[i];
            String to = changed[i];
            int c = cost[i];
            if (!adj.containsKey(from)) {
                 adj.put(from, new ArrayList<>());
            }
            adj.get(from).add(new Pair(c, to));

           validLengths.add(from.length());
}

        long ans = solve(0);
        return ans == BIG_VALUE ? -1 : ans;
    }
}