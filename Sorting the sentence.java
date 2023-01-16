class Solution {
    class Pair implements Comparator<Pair> {
        String str;
        int pos;

        public Pair() {
        }

        public Pair(String str, int pos) {
            this.str = str;
            this.pos = pos;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.pos - o2.pos;
        }
    }
    public String sortSentence(String s) {
        String[] subs = s.split(" ");
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair());
        for (int i = 0; i < subs.length; i++) {
            String s1 = subs[i];
            int p1 = Integer.parseInt(String.valueOf(s1.charAt(s1.length() - 1)));
            s1 = s1.substring(0, s1.length() - 1);

            pq.offer(new Pair(s1, p1));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (!pq.isEmpty()) {
            stringBuilder.append(pq.poll().str);
            if (i != subs.length - 1) {
                stringBuilder.append(" ");
            }
            i++;
        }
        return stringBuilder.toString();
    }
}