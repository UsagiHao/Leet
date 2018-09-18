/*
给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++){
            int result = target - nums[i];
            if (map.containsKey(result) && map.get(result) != i){
                return new int[] {i, map.get(result)};
            }
        }
        return null;
    }
}
