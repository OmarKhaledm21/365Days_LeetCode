public int maxConsecutiveAnswers(String s, int k) {
        int max1 = 0;
        int flips = 0;

        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == 'F') flips++;
            while (flips > k) {
                if (s.charAt(j) == 'F') flips--;
                j++;
            }
            max1 = Math.max(max1, i - j + 1);
        }

        // max consecutive F's after replacing T's with F
        int max2 = 0;
        flips = 0;
        j = 0;
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == 'T') flips++;
            while (flips > k) {
                if (s.charAt(j) == 'T') flips--;
                j++;
            }
            max2 = Math.max(max2, i - j + 1);
        }

        return Math.max(max1, max2);
    }