

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        i = 0
        total = 0
        while i < len(nums):
            total += min(nums[i], nums[i+1])
            i += 2
        return total
