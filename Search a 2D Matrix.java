class Solution {
public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;

		int top = 0;
		int bottom = m - 1;

		while (top <= bottom) {
			int mid = top + (bottom - top) / 2;
			if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
				return bs(matrix, target, mid, n);
			} else if (matrix[mid][0] > target) {
				bottom = mid - 1;
			} else {
				top = mid + 1;
			}
		}
		return false;
	}

	private boolean bs(int[][] matrix, int target, int row, int n) {
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (matrix[row][mid] == target) {
				return true;
			} else if (matrix[row][mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}
