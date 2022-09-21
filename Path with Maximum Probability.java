class Solution {
    class node {
        int v;
        double cost;

        public node(int v, double cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<node>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double cost = succProb[i];
            adjList[u].add(new node(v, cost));
            adjList[v].add(new node(u, cost));
        }

        double[] dist = new double[n];
        
        PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> {
            if (b.cost > a.cost) {
                return 1;
            }
            return -1;
        });

        dist[start] = 1;
        pq.add(new node(start, 1));

        while (!pq.isEmpty()) {
            int u = pq.poll().v;
            for (int i = 0; i < adjList[u].size(); i++) {
                int v = adjList[u].get(i).v;
                double v_cost = adjList[u].get(i).cost;
                if (dist[v] == 0 || dist[u] * v_cost > dist[v]) {
                    dist[v] = dist[u] * v_cost;
                    pq.add(new node(v, dist[v]));
                }
            }
        }
        return dist[end];
    }
}