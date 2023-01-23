class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        new_s = ""
        for ch in s:
            if (ord(ch) >= 97 and ord(ch) <= 122) or (ord(ch) >= 48 and ord(ch) <= 57):
                new_s += ch
        i, j = 0, len(new_s)-1
        while i <= j:
            if new_s[i] != new_s[j]:
                return False
            i += 1
            j -= 1
        return True