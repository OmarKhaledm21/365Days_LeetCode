class Solution {
     class Row implements Comparator<Row> {
        int total;
        int ind;

        public Row() {
        }

        public Row(int total, int ind) {
            this.total = total;
            this.ind = ind;
        }

        @Override
        public int compare(Row o1, Row o2) {
            if (o1.total == o2.total) {
                return o1.ind-o2.ind;
            }
            return o1.total - o2.total;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>(new Row());
        for (int i = 0; i < mat.length; i++) {
            int total = 0;
            for (int j = 0; j < mat[0].length && mat[i][j] == 1; j++) {
                total++;
            }
            pq.offer(new Row(total, i));

        }

        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty() && k!=0) {
           //System.out.println(pq.poll().ind);
            res[i++] = pq.poll().ind;
            k--;
        }
        return res;

    }
}