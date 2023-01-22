class Solution:
    def minOperations(self, nums: List[int]) -> int:
        prev = 0
        total = 0
        for num in nums:
            if num > prev:
                prev = num
                continue
            inc = (prev-num+1)
            prev = num + inc
            total += (inc)
        return total
