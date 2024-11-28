class Solution {
	public String predictPartyVictory(String senate) {
		Queue<Integer> radiant = new LinkedList<Integer>();
		Queue<Integer> dire = new LinkedList<Integer>();
		int i=0;
		for(; i<senate.length(); i++) {
			char c = senate.charAt(i);
			if(c == 'R') {
				radiant.add(i);
			}else {
				dire.add(i);
			}
		}


		int n = i;
		while(!radiant.isEmpty() && !dire.isEmpty()) {
			int n1 = radiant.peek();
			int n2 = dire.peek();
			if(n1 < n2) {
				dire.remove();
				radiant.remove();
				radiant.add(i++);
			}else {
				dire.remove();
				radiant.remove();
				dire.add(i++);
			}
		}
		if(radiant.isEmpty()) {
			return "Dire";
		}
		return "Radiant";
	}
}
