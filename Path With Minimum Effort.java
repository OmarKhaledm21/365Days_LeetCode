class Solution {
    class Pair implements Comparator<Pair> {
        int row;
        int col;
        int diff;

        public Pair() {
        }

        public Pair(int row, int col, int diff) {
            this.row = row;
            this.col = col;
            this.diff = diff;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.diff > o2.diff) {
                return 1;
            } else if (o1.diff < o2.diff) {
                return -1;
            }
            return 0;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
        int rowSize = heights.length;
        int colSize = heights[0].length;
        int[][] visited = new int[rowSize][colSize];

        pq.add(new Pair(0, 0, 0));
        int[] x = {0, 1, 0, -1};
        int[] y = {-1, 0, 1, 0};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            int curr_row = curr.row;
            int curr_col = curr.col;
            int curr_diff = curr.diff;

            visited[curr_row][curr_col] = 1;

            if (curr_row == rowSize - 1 && curr_col == colSize - 1) {
                return curr_diff;
            }

            for (int dir = 0; dir < x.length; dir++) {
                int newRow = x[dir] + curr_row;
                int newCol = y[dir] + curr_col;
                if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && visited[newRow][newCol] == 0) {
                    int diff = Math.max(curr_diff, Math.abs(heights[newRow][newCol] - heights[curr_row][curr_col]));
                    pq.add(new Pair(newRow, newCol, diff));
                }
            }


        }
        return -1;
    }
}