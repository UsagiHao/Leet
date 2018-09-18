/*
编写一个函数，其作用是将输入的字符串反转过来。

总结：一开始使用了StringBuilder sb = new StringBuilder(s);return sb.reverse().toString();但是用时过高
后来直接从尾到头逐位赋给新串，直接超时
最后从度娘学来的方法，头尾交换直至相遇，可以减少一半的交换次数
*/
class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
} 
