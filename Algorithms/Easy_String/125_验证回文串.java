/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

注意：字母大小写的考虑、特殊字符的排除
自己的解法太过暴力，用时过多
*/
class Solution {
    public boolean isPalindrome(String s) {
            s = s.toLowerCase();

    int startIndex = 0;
    int endIndex = s.length() - 1;
    while (startIndex < endIndex && startIndex < s.length() - 1) {
        char pre = s.charAt(startIndex);
        char aft = s.charAt(endIndex);
        if (!((pre >= 'a' && pre <= 'z') || (pre >= '0' && pre <= '9'))) {
            startIndex++;
            continue;
        }
        if (!((aft >= 'a' && aft <= 'z') || (aft >= '0' && aft <= '9'))) {
            endIndex--;
            continue;
        }

        if (pre != aft) {
            return false;
        }
        startIndex++;
        endIndex--;
    }

    return true;
    }
}

/*class Solution {
    boolean isAscii(char c){
        return ('0'<=c && c<='9') || ('a'<=c && c<='z') || ('A'<=c && c<='Z');
    }
    boolean equal(char a,char b){
        if('A'<=a && a<='Z')
            a=(char)(a-'A'+'a');
        if('A'<=b && b<='Z')
            b=(char)(b-'A'+'a');
        return a==b;
    }
    public boolean isPalindrome(String s) {
        char[] chs=s.toCharArray();
        int end=-1;
        for(int i=0;i<chs.length;i++)
            if(isAscii(chs[i]))
                chs[++end]=chs[i];
        for(int start=0;start<=end;start++,end--)
            if(!equal(chs[start],chs[end]))
                return false;
        return true;
    }
}*/
