/*
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

思路：双指针，一个指向头一个指向尾，无限逼近target
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int result[] = new int[2];
        while (i < j){
            int temp = numbers[i] + numbers[j];
            if (temp == target){
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            }else if (temp > target){
                --j;
            }else{
                ++i;
            }            
        }
        return result;
    }
}
