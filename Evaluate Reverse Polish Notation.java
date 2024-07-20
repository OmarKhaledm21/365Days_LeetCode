class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for (String token : tokens) {
            if (operators.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(evalExpression(a, b, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int evalExpression(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

}
