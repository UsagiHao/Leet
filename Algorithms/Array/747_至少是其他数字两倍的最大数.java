/*
在一个给定的数组nums中，总是存在一个最大元素 。

查找数组中的最大元素是否至少是数组中每个其他数字的两倍。

如果是，则返回最大元素的索引，否则返回-1。

思路：找出最大数和第二大数，将其进行比较就行
*/
class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        //找出最大值 索引
        int max = 0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] > nums[max]) max = i;
        }
        //找出第二大值 索引
        int second = max == 0 ? 1 : 0;
        for (int i = 0; i < nums.length ; i++) {
            if(max == i) continue;
            if(nums[i] > nums[second]) second = i;
        }
        return nums[second] * 2 > nums[max] ? -1:max;
    }
}
