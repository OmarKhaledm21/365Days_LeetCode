class Solution {
public int compress(char[] chars) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			char target = chars[i];
			int count = 0;
			while (i < chars.length && chars[i] == target) {
				count++;
				i++;
			}
			i--;
			result.append(target);
			if(count>1) {
				result.append(count);
			}
		}
		String resultStr = result.toString();
		for(int i=0; i<resultStr.length(); i++) {
			chars[i] = resultStr.charAt(i);
		}
		return resultStr.length();
	}
}
