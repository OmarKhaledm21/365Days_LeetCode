class Solution {
 	public int mySqrt(int x) {
		if(x<2) {
			return x;
		}
		
		int left = 1;
		int right = x;
		while(left<=right) {
			int mid = left + (right - left) /2 ;
			int res = x/ mid;
			if(mid == res) {
				return mid;
			}else if(mid < res ) {
				left = mid +1;
			}else {
				right = mid -1;
			}
		}
		return right;
	}

}
