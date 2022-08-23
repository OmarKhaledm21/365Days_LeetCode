class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0 ){
            return false;
        }
        int p = (int) (Math.log(n) / Math.log(4));
        if( (int)Math.pow(4, p) == n){
            return true;
        }
        return false;
    }
}