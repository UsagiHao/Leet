/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list_All = new ArrayList<List<Integer>>();
        if(numRows<1){
            return list_All;
        }
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list_All.add(list1);
        for(int i=2;i<=numRows;i++){
             List<Integer> list = new ArrayList<Integer>();
            list.add(1);
            List<Integer> list_pre = list_All.get(i-2);
            for(int j=1;j<i-1;j++) {
                list.add(list_pre.get(j-1)+list_pre.get(j));
            }
            list.add(1);
            list_All.add(list);
        }
        return list_All;
    }
}
