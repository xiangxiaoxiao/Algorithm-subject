/*二维数组中的查找
	在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照
	从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一
	个整数，判断数组中是否含有该整数。
思路：左下按照大小查找
*/
bool Find(vector<vector<int> > array, int target) {
	int height = array.size();
	int i = height - 1, j = 0;
	while (i >= 0 && j < array[i].size())
	{
		if (target == array[i][j])
			return true;
		if (target > array[i][j])
			j++;
		else 
			i--;
	}
	return false;
}