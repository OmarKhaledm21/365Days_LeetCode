  public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList[u].add(v);
            
            adjList[v].add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            System.out.println(node);
           
            for (int i = 0; i < adjList[node].size(); i++) {
                int neighbor = adjList[node].get(i);
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    
                    visited[neighbor] = true;
                }
            }
            if(visited[destination]){
                return true;
            }
        }
        return false;
    }