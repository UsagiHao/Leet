/*
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

思路：利用String类的substring方法，判断截取的子串和needle是否一致
一开始打算转成两个字符数组for循环判断，后来发现做不下去了,从网上找到的实现方法见法二，时间开销大于法一

法三：大佬的解法。没想到String类的indexof方法还能这么用
*/
class Solution {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        if (n2 == 0) return 0;
        if (n1 < n2) return -1;
        
        int n = n1 - n2;
        for (int i = 0; i <= n; i++){
            if(haystack.substring(i, i + n2).equals(needle)) return i;
        }
        return -1;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == "") return 0;
        if(haystack.length() < needle.length()) return -1;
        int flag = 1;
        int p;
        for(int i = 0;i < haystack.length()-needle.length()+1;++i){
            p = i;
            for(int j = 0;j < needle.length();++j){
                if(haystack.charAt(p++) != needle.charAt(j)){
                    flag = 0;
                    break;
                }
                flag = 1;
            }
            if(flag == 1) return i;
        }
        return -1;

    }
}

class Solution {
    public int strStr(String haystack, String needle) {
         return haystack.indexOf(needle);
    }
}
