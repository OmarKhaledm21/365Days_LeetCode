class Solution {
public:
    int getMoveTime(char c) {
        int ind = c - 'a';
        return ind;
    }

    int minTimeToType(string word) {
        int total = 0;
        int current_pos = 0;
        int c_pos;
        char c;
        int clockwise;
        int anticlockwise;
        for (int i = 0; i < word.length(); i++) {
            c = word[i];
            c_pos = getMoveTime(c);
            if (c_pos == current_pos) {
                total += 1;
                continue;
            } else if (c_pos > current_pos) {
                clockwise = c_pos - current_pos;
                anticlockwise = 26 - c_pos + current_pos;
            } else {
                clockwise = 26 - current_pos + c_pos;
                anticlockwise = current_pos - c_pos;
            }
            current_pos = c_pos;
            total += min(clockwise, anticlockwise);
            total += 1;
        }
        return total;
    }
};