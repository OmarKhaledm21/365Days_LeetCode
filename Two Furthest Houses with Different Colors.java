class Solution {
    public int maxDistance(int[] colors) {
        int max1=0;
        int current=0;
        int last=colors.length-1;
        
        for(int i=0;i<colors.length;i++) {
            if(colors[current]!=colors[last]) {
                max1=Math.abs(current-last);
                break;
            }
            current++;
            
        }
        
        current=0;
        int max2=0;
        
        for(int i=0;i<colors.length;i++) {
            if(colors[current]!=colors[last]) {
                max2=Math.abs(current-last);
                break;
            }
            last--;
            

        }
        return Math.max(max1,max2);
    }
}