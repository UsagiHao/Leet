/*
给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。

我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int index = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i]; 
        } 
        for (int i = 0; i < nums.length; i++){
            if (i == 0){
              leftSum = 0;  
            } else {
                leftSum += nums[i - 1];
            }
            rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
}
