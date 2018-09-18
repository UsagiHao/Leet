/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

思路：类似于第26题删除数组中重复元素的双指针法
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int count = 0;
        for (int j = i; j < nums.length; j++){
            if (nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        for (; i < nums.length; i++){
            nums[i] = 0;
        }
        return;
    }
}
