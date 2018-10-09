/*
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"

思路：利用二进制相加的规则，当前位相加，加上进位再%2则为结果，/2则为下一个进位。
可以先建立一个StringBuilder类型的result，从后往前，将每一位相加，结果加入result，最后反转输出。
*/
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0){
            int sum = 0;
            if (i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }
            sum += carry;
            carry = sum / 2;
            result.append(sum % 2);
        }
        if (carry != 0) result.append(1);
        return result.reverse().toString();
    }
}
