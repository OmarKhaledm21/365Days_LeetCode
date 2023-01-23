class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        hash = {}
        res = []
        for i in range(len(numbers)):
            hash[numbers[i]] = i

        for i in range(len(numbers)):
            paired = target - numbers[i]
            if hash.get(paired):
                res.append(hash[paired]+1)
                res.append(i+1)
                break
        return sorted(res)