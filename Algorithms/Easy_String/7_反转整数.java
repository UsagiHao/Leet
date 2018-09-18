/*
给定一个 32 位有符号整数，将整数中的数字进行反转。

注意：要防止溢出！
*/
class Solution {
    public int reverse(int x) {
        int result = 0;
        while(x != 0){
            int a = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && a > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && a < -8)) return 0;
            result = result * 10 + a;

        }
        return result;
    }
}
