class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max_amt = 0
        for account in accounts:
            local = 0
            for amt in account:
                local+= amt
            max_amt = max(local,max_amt)
        return max_amt