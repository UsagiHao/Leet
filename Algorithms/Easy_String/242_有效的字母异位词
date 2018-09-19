/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

思路：建立一个字母表数组，s中出现的字符，对应数值++，t中出现的字符，对应数字--
也可以用hashset
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int [] alphabet = new int [26];
        for (int i = 0; i < s.length(); i++){
            alphabet[s.charAt(i) - 'a']++; 
        }
        for (int i = 0; i < t.length(); i++){
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++){
            if (alphabet[i] != 0) return false;
        }
        return true;
    }
}
