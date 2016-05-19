/*
题目描述

请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
给定一个操作序列int[][2] ope(C++为vector<vector<int>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，后一个数无意义。请返回一个int[][](C++为vector<vector<int>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
*/
class SetOfStacks {
public:
	vector<vector<int> > setOfStacks(vector<vector<int> > ope, int size) {
		// write code here
		vector<vector<int> > sint;
		vector<int> temp;
		for (int i = 0; i < ope.size(); i++)
		{
			if (ope[i][0] == 1)//push
			{
				if (temp.size() < size)
					temp.push_back(ope[i][1]);
				else
				{
					sint.push_back(temp);
					while (temp.size())
						temp.pop_back();
					temp.push_back(ope[i][1]);
				}
			}
			else//pop
			{
				if (temp.size())
				  temp.pop_back();
				else if (!sint.empty())
				{
					temp = sint[sint.size()-1];
					sint.pop_back();
		         
					temp.pop_back();
				}
			}
		}
		if (temp.size())
			sint.push_back(temp);
		return sint;
	}
};