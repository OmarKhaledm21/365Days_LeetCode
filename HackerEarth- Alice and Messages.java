import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int n = sc.nextInt();

        HashSet<String> msgs = new HashSet<>();
        int count = 0;
        for(int i=0; i<n; i++){
            String msg = sc.next();
            msgs.add(msg);
        }

        HashSet<String> visited = new HashSet<>();
        for(String msg : msgs){
            String enc = encoder(msg,alpha);
            if(msgs.contains(enc) && !visited.contains(enc)){
                count++;
                visited.add(enc);
                visited.add(msg);
            }
        }
        System.out.println(n-count);
    }

    public static String encoder(String msg,int[] alpha){
        StringBuilder res = new StringBuilder();
        for(int j=0; j<msg.length(); j++){
            char c = msg.charAt(j);
            int ind = c-97;
            res.append((char)alpha[25-ind]);
        }
        return res.toString();
    }
}