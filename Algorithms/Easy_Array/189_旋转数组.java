/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
题目要求空间复杂度o（1）
一开始完全没有想法，从度娘找到了一个很巧妙的方法：
先reverse前n-k项，再reverse后k项
最后reverse整个数组
*/
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k ==0) return;
        int n1 = n - k;
        for (int i = 0; i < n1 / 2; i++){
            int temp = nums[i];
            nums[i] = nums[n1 - i - 1];
            nums[n1 - i - 1] = temp;
        }
        for (int i = n1; i < n1 + k /2 ; i++){
            int temp = nums[i];
            nums[i] = nums[2 * n - i - 1 - k]; 
            nums[2 * n - i  - 1 - k] = temp;
        }
        for (int i = 0; i < n / 2; i++){
            int temp = nums[i];
            nums[i] = nums[n - i -1];
            nums[n - i - 1] = temp;
        }
        return;
    }
}

/*
更好的reverse方法如下
class Solution {
    public void rotate(int[] nums, int k) {
        int x = k%nums.length;
        x = nums.length - x;
        nizhi(nums,0,x-1);
        nizhi(nums,x,nums.length-1);
        nizhi(nums,0,nums.length-1);
    }
    private void nizhi(int[] nums,int begin,int end){
        for (int i = begin,j=end; i < j; i++,j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}

*/
