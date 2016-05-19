/*
题目描述

请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
给定一个int[] numbers(C++中为vector&ltint>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
测试样例：
[1,2,3,4,5]
返回：[5,4,3,2,1]
*/
class TwoStacks {
public:
	vector<int> twoStacksSort(vector<int> numbers) {
		// write code here
		vector<int> sint;
		int i = 0, len = numbers.size(),temp;
		while (numbers.size())
		{
			if (sint.empty())
			{
				temp = numbers.back();
				sint.push_back(temp);
				numbers.pop_back();
			}
			else
			{
				temp = numbers.back();
				numbers.pop_back();
				while (!sint.empty() && temp <= sint.back())
				{
					numbers.push_back(sint.back());
					sint.pop_back();
				}
				sint.push_back(temp);
			}
		}
		reverse(sint.begin(), sint.end());
		return sint;
	}
};