import java.util.Hashtable;
import java.util.Stack;
class Solution {
    final Hashtable<String,String> expressions = new Hashtable<>();
    public boolean isValid(String s) {
        expressions.put("]","[");
        expressions.put(")","(");
        expressions.put("}","{");

        Stack<String> stack = new Stack<>();
        boolean exp = true;
        for(int i=0; i<s.length(); i++){
            String c = String.valueOf(s.charAt(i));
            if(c.equals("]")  || c.equals(")") || c.equals("}")){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek().equals( expressions.get(c) ) ){
                    stack.pop();
                    exp = false;
                    stack = validateStack(stack);
                }
            }
            if(exp){
                stack.add(c);
            }
            exp = true;

        }
        return stack.isEmpty();
    }

    public Stack<String> validateStack(Stack<String> stack){
        if(!stack.isEmpty()){
            boolean exp = true;
            while (true){
                String c = stack.pop();
                if(c.equals("]")  || c.equals(")") || c.equals("}")){
                    
                    if(stack.peek().equals( expressions.get(c) ) ){
                        stack.pop();
                    }else{
                        stack.add(c);
                        break;
                    }
                }else{
                    stack.add(c);
                    break;
                }
            }
        }
        return stack;
    }
}