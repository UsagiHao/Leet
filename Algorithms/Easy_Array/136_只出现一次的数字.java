/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
*/

/*
思路：根据异或运算的特点，相同的数字经过异或运算后结果为0，除单独出现一次的数字外，其他数字都是出现两次的，那么这些数字经过异或运算后结果一定是0。而任何数字与0进行异或运算都是该数字本身。所以对数组所有元素进行异或运算，运算结果就是题目的答案。
*/
class Solution {
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            num = num ^ nums[i];
        }
        return num;
    }
}

/*
其他方法：
方法二（求差法）：
　　思路：先对数组排序，显而易见的，单独出现一次的数据必然是出现在数组下标为偶数的位置（下标从0开始），那么所有奇数下标的元素之和减去偶数下标的元素之和，就是需要求得的结果。
方法三（比较法）：
　　思路：先对数组进行排序，然后对 nums[i] 和 nums[i + 1]进行比较，如相等，i += 2，继续下一组比较，直到取到不相等的一组。
方法四（去重法）：
　　思路：利用HashSet的特性，删除重复的数组元素，最后剩下一个单独的元素，返回即可。
     public static int singleNumber(int[] nums) {
         Set<Integer> set = new HashSet<>();
         for (int i = 0; i < nums.length; i++) {
             if (!set.add(nums[i])) { // add成功返回true，如果set中已有相同数字，则add方法会返回false
                 set.remove(nums[i]); // 删除重复出现的数字
             }
         }
         return set.iterator().next();9     }
         
 上述方法的底层实现均不符合线性时间复杂度o（n）的要求
*/
