/*
题目描述

假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。
给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
测试样例：
"Hello world","worldhello "
返回：false
"waterbottle","erbottlewat"
返回：true
*/
class ReverseEqual {
public:
	bool checkReverseEqual(string s1, string s2) {
		// write code here
		string temp;
		int i, j, len;
		if (s1.size() != s2.size())
			return false;
		len = s1.size();
		for (i = 0; i < len; i++)
		{
			if (s1[i] == s2[0])
			{
				temp = s1.substr(i, len - i) + s1.substr(0, i);
				if (temp.compare(s2) == 0)//相等返回0
					return true;
			}
		}
		return false;
	}
};