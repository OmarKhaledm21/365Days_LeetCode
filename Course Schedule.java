class Solution {
    	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int[] indegree = new int[numCourses];
		
		for (int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < prerequisites.length; i++) {
			int course = prerequisites[i][0];
			int pre = prerequisites[i][1];
			adjList.get(pre).add(course);
			indegree[course]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
		while (!queue.isEmpty()) {
			int current = queue.poll();
			res.add(current);
			for (int course : adjList.get(current)) {
				indegree[course]--;
				if (indegree[course] == 0) {
					queue.add(course);
				}
			}
		}

		return res.size() == numCourses;
	}
}
