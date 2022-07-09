class Solution {
   public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
            set.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') {
                    continue;
                }
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
            set.clear();
        }

        int m = 0;
        int n = 0;
        for(int i=0; i<9; i++){
            set.clear();
            if(i%3 == 0){
                m = i;
                n=0;
            }
            for(int j=0; j<9; j++){
                if(Character.isDigit(board[n][m])){
                    if(set.contains(board[n][m]))
                        return false;
                    set.add(board[n][m]);
                }
                m++;
                if(m % 3 == 0){
                    m -= 3;
                    n++;
                }
            }
        }


        return isValid;
    }
}