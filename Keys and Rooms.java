class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            Iterator<Integer> iter = rooms.get(v).iterator();
            while (iter.hasNext()) {
                int next = iter.next();
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;

    }
}