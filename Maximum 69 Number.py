class Solution:
    def maximum69Number(self, num: int) -> int:
        digits = list(str(num))
        if '6' not in digits:
            return num
        digits[digits.index('6')] = '9'
        return int(''.join(digits))