/*
题目描述

有一副由NxN矩阵表示的图像，这里每个像素用一个int表示，请编写一个算法，在不占用额外内存空间的情况下(即不使用缓存矩阵)，将图像顺时针旋转90度。
给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于500，图像元素小于等于256。
测试样例：
[[1,2,3],[4,5,6],[7,8,9]],3
返回：[[7,4,1],[8,5,2],[9,6,3]]
*/
class Transform {
public:
	vector<vector<int> > transformImage(vector<vector<int> > mat, int n) {
		// write code here
		int i,j,temp;
		int temp = 0;
		for (int j = 0; j<n - 1; j++){
			for (int i = 0; i<n - j - 1; i++){
				temp = mat[j][i];
				mat[j][i] = mat[n - i - 1][n - j - 1];
				mat[n - i - 1][n -j - 1] = temp;
			}
		}

		for (int j = 0; j<(n / 2); ++j){
			for (int i = 0; i<n; ++i){
				temp = mat[j][i];
				mat[j][i] = mat[n - j - 1][i];
				mat[n - j - 1][i] = temp;
			}

		}
		return mat;
	}