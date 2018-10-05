/*
给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出:  [1,2,4,7,5,3,6,8,9]
解释:

说明:

给定矩阵中的元素总数不会超过 100000 。

思路：找准特殊情况好好判断就行
*/
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int M = matrix.length;
        if(M==0){
            return new int[]{};
        }
        int N = matrix[0].length;
        int[] array = new int[N*M];
        int a=0,b=0,c=0;
        int length = N*M;
        boolean flag = false;
        while(c!=length){
            array[c] = matrix[a][b];
            c++;
            if((a==0||b==N-1)&&!flag){
                if(b==N-1){
                    a++;
                }else{
                    b++;
                }
                flag = true;
            }else if((a==M-1||b==0)&&flag){
                if(a==M-1){
                    b++;
                }else{
                    a++;
                }
                flag = false;
            }else{
                if(flag){
                    a++;b--;
                }else{
                    a--;b++;
                }
            }
        }
        return array;
    }
}
