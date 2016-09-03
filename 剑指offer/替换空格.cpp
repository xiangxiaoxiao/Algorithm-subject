
/*替换空格
	请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	思路：先数出空格个数，然后构造新的字符串进行复制
	(要求：在原先的字符串上操作，并且保证原字符串有足够长的空间来存放替换后的字符串，那么我们就得另想方法。)
*/
void replaceSpace(char *str, int length) {
	int blanknumber = 0;
	int i;
	for (i = 0; str[i] != '\0'; i++) {
		if (str[i] == ' ') {
			blanknumber++;
		}
	}
	int k = i + 2 * blanknumber;
	if (k > length)
		return;
	str[k] = '\0';//此行必不可少
	int point1 = i - 1, point2 = k - 1;
	for (; point1 >= 0 && point2 > point1; point1--) {
		if (str[point1] == ' ') {
			str[point2--] = '0';
			str[point2--] = '2';
			str[point2--] = '%';
		}
		else
			str[point2--] = str[point1];
	}

}