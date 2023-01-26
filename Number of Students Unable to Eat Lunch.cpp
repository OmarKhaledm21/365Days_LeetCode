class Solution {
public:
    int countStudents(vector<int> &students, vector<int> &sandwiches) {
        int student_cnt = students.size(), c = 0, s = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students[i] == 0) {
                c++;
            } else {
                s++;
            }
        }
        for (int i = 0; i < sandwiches.size(); i++) {
            if (sandwiches[i] == 0) {
                if (c > 0) {
                    student_cnt--;
                    c--;
                } else {
                    return student_cnt;
                }
            } else {
                if (s > 0) {
                    student_cnt--;
                    s--;
                } else {
                    return student_cnt;
                }
            }
        }
        return student_cnt;
    }
};