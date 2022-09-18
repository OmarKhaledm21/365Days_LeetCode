 public int findJudge(int n, int[][] trust) {
        boolean[] visited = new boolean[n + 1];
        int[] count = new int[n + 1];
        count[0] = 1;
        visited[0] = true;

        for (int i = 0; i < trust.length; i++) {
            int u = trust[i][0];
            int v = trust[i][1];
            visited[u] = true;
            count[v]++;
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }