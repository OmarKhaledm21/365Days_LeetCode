class Solution {

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        Stack<Character> charStack = new Stack<Character>();
        Stack<Integer> intStack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (intStack.isEmpty() && !Character.isDigit(c)) {
                charStack.push(c);
                continue;
            }
            if (Character.isDigit(c)) {
                StringBuilder nummm = new StringBuilder();
                while (Character.isDigit(c)) {
                    nummm.append(c);
                    c = s.charAt(++i);
                }
                intStack.push(Integer.valueOf(nummm.toString()));
                i--;
                continue;
            }
            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                while (charStack.peek() != '[') {
                    temp.append(charStack.pop());
                }
                charStack.pop();
                String curr = temp.reverse().toString().repeat(intStack.pop());
                for (char q : curr.toCharArray()) {
                    charStack.push(q);
                }
            } else {
                charStack.push(c);
            }
        }

        while (!charStack.isEmpty()) {
            result.append(charStack.pop());
        }

        return result.reverse().toString();
    }
}
