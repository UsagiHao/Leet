/*
给定一个整数，写一个函数来判断它是否是 3 的幂次方。
你能不使用循环或者递归来完成本题吗？

思路：使用log的换底公式
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        return (Math.log10(n)/Math.log10(3))%1 == 0;   
    }
}
