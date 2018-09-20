/*
报数序列是指一个整照其中的整数的顺序进数序列，按行报数，得到下一个数。其前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

注意：整数顺序将表示为一个字符串。
思路：拿到这个题目的时候毫无思路，搜索借鉴了别人的解法。
由于每一次的结果都是根据上一次的结果得来的，可以考虑利用递归
另外，StringBuilder的append方法要比string类的+操作效率更高
注意外层for循环的特殊性

*/
public class Solution {
	public String countAndSay(int n) {
		if(n == 1) {
			return "1";
		}
		String pre = countAndSay(n - 1);
		StringBuilder stringBuilder = new StringBuilder();
		for(int k = 0; k < pre.length();) {
			int index = 1;
			for (int i = k; i < pre.length() - 1; i++) {
				if(pre.charAt(i) == pre.charAt(i + 1)) {
					index++;
				}else {
					break;
				}
			}
			stringBuilder.append(String.valueOf(index));
			stringBuilder.append(pre.charAt(k));
			k += index;
		}
		return stringBuilder.toString();
	}
}
