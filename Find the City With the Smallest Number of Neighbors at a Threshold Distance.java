class Solution {
     class Node implements Comparator<Node> {
        int v;
        int cost;

        public Node() {
        }

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.cost > o2.cost) {
                return 1;
            }
            return -1;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Integer> no_of_cities = new ArrayList<>();
        ArrayList<Node>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        for (int i = 0; i < n; i++) {
            no_of_cities.add(dijkstra(adj, n, i, distanceThreshold));
        }

        int ind = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < no_of_cities.size(); i++) {
            int s = no_of_cities.get(i);
            if (s <= min) {
                min = s;
                ind = i;
            }
        }
        return ind;
    }

    public int dijkstra(ArrayList<Node>[] adj, int n, int src, int threshold) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Node());
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;

        dist[src] = 0;

        pq.add(new Node(src,0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int u = current.v;

            if(!visited[u]){
                visited[u] = true;

                int edgeDistance = -1;
                int newDistance = -1;

                // All the neighbors of v
                for (int i = 0; i < adj[u].size(); i++) {
                    Node v = adj[u].get(i);

                    // If current node hasn't already been processed
                    if (!visited[v.v]) {
                        edgeDistance = v.cost;
                        newDistance = dist[u] + edgeDistance;

                        // If new distance is cheaper in cost
                        if (newDistance < dist[v.v])
                            dist[v.v] = newDistance;

                        // Add the current node to the queue
                        pq.add(new Node(v.v, dist[v.v]));
                    }
                }

            }

        }
        
        int total =0;
        for(int i=0; i< dist.length; i++){
            if(dist[i]<=threshold){
                total++;
            }
        }
        return total;
    }
}