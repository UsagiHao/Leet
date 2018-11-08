/*
给定一个字符串，逐个翻转字符串中的每个单词。

示例:  

输入: "the sky is blue",
输出: "blue is sky the".
说明:

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

思路：分割成string数组再拼接
String中的trim函数：去除字符串首尾的空格
split(" +")函数：利用正则表达式进行1/多空格的分割
解法二换成StringBuilder之后快了很多
*/
public class Solution {
    public String reverseWords(String s) {
        String res = "";
        String[] words = s.trim().split("\\s+");
        //String[] words = s.trim().split(" +");  也能得到同样的效果
        for (int i = words.length - 1; i > 0; --i) {
            res += words[i] + " ";   
        }
        return res + words[0];
    }
}

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }
        String[] words = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]).append(" ");
        }

        return sb.append(words[0]).toString();
    }
}
