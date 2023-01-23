class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        i = 0
        j = 0
        glen = len(grid)
        new_grid = []
        while i <= glen-3:
            new_col = []
            while j <= glen-3:
                total = 0
                for k in range(i, i+3):
                    for r in range(j, j+3):
                        total = max(total, grid[k][r])
                new_col.append(total)
                j += 1
            j = 0
            i += 1
            new_grid.append(new_col)
        return new_grid