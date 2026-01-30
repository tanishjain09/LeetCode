class Solution {
    class Pair {
        long cost;
        String node;

        Pair(long cost, String node) {
            this.cost = cost;
            this.node = node;
        }
    }

    long BIG_VALUE = (long) 1e10;
    Map<String, List<Pair>> adj = new HashMap<>();
    Map<String, Map<String, Long>> dijkstraMemo = new HashMap<>();
    long[] dpMemo;
    String sourceStr, targetStr;
    TreeSet<Integer> validLengths = new TreeSet<>();

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        sourceStr = source;
        targetStr = target;
        dpMemo = new long[10001];
        Arrays.fill(dpMemo, -1);

        for (int i = 0; i < original.length; i++) {
            if (!adj.containsKey(original[i])) {
                adj.put(original[i], new ArrayList<>());
            }

            adj.get(original[i]).add(new Pair(cost[i], changed[i]));
            validLengths.add(original[i].length());
        }
        long res = solve(0);
        return res == BIG_VALUE ? -1 : res;
    }

    private long solve(int ind) {
        if (ind >= sourceStr.length())
            return 0;

        if (dpMemo[ind] != -1)
            return dpMemo[ind];
        long minCost = BIG_VALUE;

        if (sourceStr.charAt(ind) == targetStr.charAt(ind)) {
            minCost = solve(ind + 1);
        }
        for (int len : validLengths) {
            if (ind + len > sourceStr.length())
                break;

            String srcSub = sourceStr.substring(ind, ind + len);
            String tgtSub = targetStr.substring(ind, ind + len);

            if (!adj.containsKey(srcSub)) {
                continue;
            }
            long pathCost = dijkstra(srcSub, tgtSub);
            if (pathCost == BIG_VALUE)
                continue;
            minCost = Math.min(minCost, pathCost + solve(ind + len));

        }
        return dpMemo[ind] = minCost;
    }

    private long dijkstra(String start, String end) {
        if (dijkstraMemo.containsKey(start) &&
                dijkstraMemo.get(start).containsKey(end)) {
            return dijkstraMemo.get(start).get(end);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        Map<String, Long> res = new HashMap<>();
        res.put(start, 0L);
        pq.offer(new Pair(0, start));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long currCost = curr.cost;
            String node = curr.node;

            if (node.equals(end))
                break;
            if (!adj.containsKey(node))
                continue;
            for (Pair p : adj.get(node)) {
                String adjNode = p.node;
                long edgeCost = p.cost;

                long newCost = currCost + edgeCost;
                if (!res.containsKey(adjNode) || newCost < res.get(adjNode)) {
                    res.put(adjNode, newCost);
                    pq.offer(new Pair(newCost, adjNode));
                }
            }
        }
        long finalCost = res.getOrDefault(end, BIG_VALUE);
        if (!dijkstraMemo.containsKey(start)) {
            dijkstraMemo.put(start, new HashMap<>());
        }

        dijkstraMemo.get(start).put(end, finalCost);

        return finalCost;
    }
}