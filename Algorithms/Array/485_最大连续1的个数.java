/*
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。

思路：直接顺序遍历统计
没想到双指针的解法具体该怎么用（感觉用了双指针也是这样的思路，还不如不用省事一点）
*/
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int max = 0;
        for(int n:nums){
            if(n == 1){
                sum ++;
            }else {
                max = max > sum ? max : sum;
                sum = 0;
            }
        }
        return max > sum ? max : sum;
    }
}
