class Solution {
  List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        int V = graph.length;
        List<Integer>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                int neighbor = graph[i][j];
                adjList[i].add(neighbor);
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(adjList[i]);
        }
        printAllPaths(0, V - 1, adjList, V);
        return res;
    }

    public void printAllPaths(int s, int d, List<Integer>[] adj, int V) {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();

        pathList.add(s);

        printAllPathsUtil(s, d, isVisited, pathList, adj);
    }

    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList, List<Integer>[] adjList) {

        if (u.equals(d)) {
            System.out.println(localPathList);
            
            res.add(new ArrayList<>(localPathList));
            return;
        }
        isVisited[u] = true;

        for (Integer i : adjList[u]) {
            if (!isVisited[i]) {

                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList, adjList);

                localPathList.remove(i);
            }
        }

        isVisited[u] = false;
    }
}