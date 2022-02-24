class Solution {
public:
    bool isPalindrome(int x) {
         long revNum = 0;
    int temp = x;
    while (temp>0){
        revNum = (revNum*10) + (temp%10);
        temp /= 10;
    }

    return revNum == x;
    }
};