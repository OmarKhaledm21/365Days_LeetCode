class Solution {
  public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		Set<Integer> seti = new HashSet();
		Set<Integer> setj = new HashSet();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					seti.add(i);
					setj.add(j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (seti.contains(i) || setj.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
