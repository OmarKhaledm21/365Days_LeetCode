
class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().intToRoman(3999)
        );
    }

    public String intToRoman(int num) {
        String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] integers = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder roman_num = new StringBuilder();

        int roman_char_convert = 0;
        for (int i = integers.length - 1; i >= 0; i--)
        {
            roman_char_convert = num / integers[i];
            num %= integers[i];
            while (roman_char_convert > 0)
            {
                roman_num.append(romans[i]);
                roman_char_convert--;
            }
        }

        return roman_num.toString();
    }
}