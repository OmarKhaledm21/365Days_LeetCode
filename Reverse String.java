class Solution {
    public void reverseString(char[] s) {
        reverseStringRec(0, s.length - 1, s);
    }

    public void reverseStringRec(int start, int end, char[] s) {
        if (start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        reverseStringRec(start + 1, end - 1, s);
    }

}