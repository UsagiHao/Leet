/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

思路一：使用hashmap存储character和integer的键值对，如果该字符出现了多次则将值赋为-1，最后遍历hashmap寻找不为-1的值
问题：hashmap是无序的，找到的那个值不一定是第一个不为-1的值！
     可以使用LinkedHashMap，LinkedHashMap也是一个HashMap,但是内部维持了一个双向链表,可以保持顺序
     关于map的遍历，可以使用 for (Map.Entry<Character, Integer> entry : map.entrySet()) {map.getKey()...map.getValue()...}
     


思路二：大佬的思路。
利用string类的indexof和lastindexof方法来判断是否只出现一次
之后再寻找最早出现的那个字符
*/
class Solution {
    public int firstUniqChar(String s) {
        Map <Character, Integer> map = new LinkedHashMap<>();
        char [] word = s.toCharArray();
        for (int i = 0; i < s.length(); i++){
            if (!map.containsKey(word[i])){
                map.put(word[i], i);
            }else{
                map.put(word[i], -1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1){
                return entry.getValue();
            }
        }
        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        int res = -1;
        
        for(char ch='a'; ch<='z'; ch++) {
            int index = s.indexOf(ch);
            if(index != -1 && index == s.lastIndexOf(ch)) {
                res = res == -1?index:Math.min(res, index);
            }
        }
        
        return res;
    }
}
