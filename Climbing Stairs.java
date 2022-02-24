import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(2));
    }

    public static int[] memoization = new int[46];

    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        if(memoization[n]!=0){
            return memoization[n];
        }

        memoization[n] = climbStairs(n-1) + climbStairs(n-2);
        return memoization[n];
    }
}