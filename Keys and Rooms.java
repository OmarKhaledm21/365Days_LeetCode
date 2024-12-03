class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        int counter = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int room = queue.poll();

            for (int key : rooms.get(room)) {
                if (!visited[key]) {

                    counter++;
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }

        return (counter+1) == rooms.size();
    }

}
