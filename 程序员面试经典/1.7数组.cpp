/*
题目描述

请编写一个算法，若MxN矩阵中某个元素为0，则将其所在的行与列清零。
给定一个MxN的int[][]矩阵(C++中为vector>)mat和矩阵的阶数n，请返回完成操作后的int[][]矩阵(C++中为vector>)，保证n小于等于300，矩阵中的元素为int范围内。
测试样例：
[[1,2,3],[0,1,2],[0,0,1]]
返回：[[0,0,3],[0,0,0],[0,0,0]]
*/
class Clearer {
public:
	vector<vector<int> > clearZero(vector<vector<int> > mat, int n) {
		// write code here
		if (mat.empty())
			return vector<vector<int> >();
		int len1 = mat.size();
		int len2 = mat[0].size();
		bool *sign1 = new bool[len1]();
		bool *sign2 = new bool[len2]();
		for (int i = 0; i<len1; i++)
		for (int j = 0; j<len2; j++)
		if (mat[i][j] == 0)
		{
			sign1[i] = true;
			sign2[j] = true;
		}
		for (int i = 0; i<len1; i++)
		for (int j = 0; j<len2; j++)
		if (sign1[i] || sign2[j])
			mat[i][j] = 0;
		return mat;
	}
};