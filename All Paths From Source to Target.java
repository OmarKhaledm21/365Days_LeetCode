class Solution {
     public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(paths, new ArrayList<>(), graph, 0);
        return paths;

    }
    public void dfs(List<List<Integer>> listAns, List<Integer> curr, int[][] graph, int pos) {
        curr.add(pos);
        if (pos == graph.length - 1) {
            listAns.add(curr);
            return;
        }


        for (int i : graph[pos]) {
            List<Integer> temp = new ArrayList<>(curr);
            dfs(listAns, temp, graph, i);
        }

    }
}