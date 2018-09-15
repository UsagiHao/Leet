/*统计所有小于非负整数 n 的质数的数量。*/
/*使用埃拉托色尼筛法
设置一个boolean数组notPrime，默认所有的元素值都会设置为false 
如果i是一个质数，i将i的倍数设置为非质数 
如是i是一个合数，则它必定已经设置为true了，因为是从2开始处理的
*/
class Solution {
    public int countPrimes(int n) {
                
        if (n <= 2) {
            return 0;
        }
        
        int count = 0;
        boolean [] notPrime = new boolean [n];
        notPrime[0] = true;
        notPrime[1] = true;


        for (int i = 2; i * i < n; i++){
            if (!notPrime[i]){
                for (int j = 2 * i; j < n; j += i){
                    notPrime[j] = true;
                }
            }
        }
        
        for (int i = 0; i < n; i++){
            if (!notPrime[i]){
                count++;
            }
        }
        return count;
    }
}
