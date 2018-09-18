/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。
*/
class Solution {
    public int[] plusOne(int[] digits) {
        boolean add = true;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9 ) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            } 
        }
        
        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        return newArray;
    }
}
