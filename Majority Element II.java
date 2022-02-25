public List<Integer> majorityElement(int[] nums) {
        if(nums.length==0){
            return Arrays.asList(0);
        }else if(nums.length==1){
            return Arrays.asList(nums[0]);
        }
        Hashtable<Integer,Integer> elements = new Hashtable<>();
        List<Integer> res =new ArrayList<>();
        int th = (int) Math.floor(nums.length/3.0);

        for(int i=0; i< nums.length; i++){
            if(elements.containsKey(nums[i])){
                int n = elements.get(nums[i]) +1;
                elements.put(nums[i],n);
                if(n > th){
                    if(!res.contains(nums[i]))
                        res.add(nums[i]);

                }
            }else{
                if(1 > th){
                    if(!res.contains(nums[i]))
                        res.add(nums[i]);
                }
                elements.put(nums[i],1);
            }
        }

        return res;
    }