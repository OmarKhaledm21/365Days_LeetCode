public int majorityElement(int[] nums) {
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        Hashtable<Integer,Integer> majority = new Hashtable<>();
        int max=0;
        int element=0;
        for(int i=0; i< nums.length; i++){
            if(majority.containsKey(nums[i])){
                int c = majority.get(nums[i])+1;
                majority.put(nums[i],c+1);
                if(c>max){
                    max=c;
                    element = nums[i];
                }
            }else{
                majority.put(nums[i],1);
            }

        }
        if(max==1){
            return 0;
        }
        return element;
    }