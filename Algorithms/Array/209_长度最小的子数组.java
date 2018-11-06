/*
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

思路：快慢双指针遍历数组（附上大佬的解法）
*/
//自己的方法踩了无数坑，注意返回值（防止不存在子数组之和>=s的情况），注意right指针不能越界
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        
        if (nums.length == 0) return 0;
        int sum = 0;

        while (left < nums.length){
            if (sum < s && right <nums.length){
                sum += nums[right++];
            }else {
                sum -= nums[left++];
            }
            if (sum >= s)result = Math.min(result, right - left);

        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= s){
                if(i - start + 1 < len){
                    len = i - start + 1;
                }
                sum -= nums[start];
                start++;
            } 
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
