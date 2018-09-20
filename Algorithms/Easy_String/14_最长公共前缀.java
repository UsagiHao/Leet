/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

思路：拿每个字符串和temp逐位比较
大佬的解法：使用string类的indexof方法来判断
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        String temp = strs[0];
        for (int i = 1; i < n; i++){
            if (strs[i].length() == 0) return "";
            if (temp.length() <= strs[i].length()){
                for (int j = 0; j < temp.length(); j++){
                    if (temp.charAt(j) != strs[i].charAt(j)){     //逐位比较，出现不一致的一位时截断temp
                        temp = temp.substring(0, j);
                        break;
                    }
                }
            }else {
                for (int j = 0; j < strs[i].length(); j++){
                    if (temp.charAt(j) != strs[i].charAt(j)){
                        temp = temp.substring(0, j);
                        break;
                    }
                    if (j == strs[i].length() - 1){     //如果strs[i]比temp短的话，把strs[i]赋给temp
                      temp = strs[i];  
                    } 
                }
            }
        }
        return temp;
    }
}

class Solution {
  public String longestCommonPrefix(String[] strs) {
       if (strs.length == 0) {
           return "";
       }
       String s = strs[0];
       for (int i = 1; i < strs.length; i++) {
           while (strs[i].indexOf(s) != 0) {
               s = s.substring(0, s.length() - 1);
               if (s.isEmpty()) {
                   return "";
               }
           }
       }
       return s;
    }
}
