/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

思路：找准规律，找准循环终止条件
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        result.add(matrix[0][0]);
        int i = 0, j = 0;
        int xMin = 0, yMin = 0;
        int xMax = matrix.length - 1;
        int yMax = matrix[0].length - 1;
        while (true){
            while (j < yMax){
                result.add(matrix[i][++j]);   
            }
            if (++xMin > xMax) break;
            while (i < xMax){
                result.add(matrix[++i][j]);
            }
            if (--yMax < yMin) break;
            while (j > yMin){
                result.add(matrix[i][--j]);
            }
            if (--xMax < xMin) break;
            while (i > xMin){
                result.add(matrix[--i][j]);
            }
            if (++yMin > yMax) break;
        }
        return result;
    }
}
