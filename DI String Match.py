class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        res = []
        i_counter = 0
        d_counter = len(s)

        for i in s:
            if i == 'I':
                res.append(i_counter)
                i_counter += 1
            else:
                res.append(d_counter)
                d_counter -= 1
        if s[-1] == 'I':
            res.append(i_counter)
        else:
            res.append(d_counter)
        return res