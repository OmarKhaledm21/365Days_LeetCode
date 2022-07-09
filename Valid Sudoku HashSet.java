
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        HashSet<Character> box = new HashSet<>();

        int m = 0;
        int n = 0;
        for(int i = 0; i < 9; i++){
            row.clear();
            col.clear();
            box.clear();
            if(i % 3 == 0){
                m = i;
                n = 0;
            }
            for(int j = 0; j < 9; j++){
                if(Character.isDigit(board[i][j])){
                    if(row.contains(board[i][j]))
                        return false;
                    row.add(board[i][j]);
                }
                if(Character.isDigit(board[j][i])){
                    if(col.contains(board[j][i]))
                        return false;
                    col.add(board[j][i]);
                }
                if(Character.isDigit(board[n][m])){
                    if(box.contains(board[n][m]))
                        return false;
                    box.add(board[n][m]);
                }
                m++;
                if(m % 3 == 0){
                    m -= 3;
                    n++;
                }
            }
        }
        return true;
    }

}