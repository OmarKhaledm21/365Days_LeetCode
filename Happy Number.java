class Solution {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        ArrayList<Integer> digits = new ArrayList<>();
        boolean happy = false;

        while (!happy) {
            while (n != 0) {
                digits.add(n % 10);
                n = n / 10;
            }
            n = sumSquare(digits);
            if (n == 1) {
               return true;
            }
            if(n<10 && n>1 && n!=7) {
                return false;
            }
            digits.clear();
        }

        return happy;
    }

    public int sumSquare(ArrayList<Integer> digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += (digit * digit);
        }
        return sum;
    }

}