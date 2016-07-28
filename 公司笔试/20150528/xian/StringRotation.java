package xian;

public class StringRotation {

	public static String rotate1(String str, int apartIndex) {
		if (str == null || apartIndex <= 0 || apartIndex >= str.length()) {
			return str;
		}
		char[] charArr = str.toCharArray();
		reverse1(charArr, 0, apartIndex - 1);
		reverse1(charArr, apartIndex, charArr.length - 1);
		reverse1(charArr, 0, charArr.length - 1);
		return String.valueOf(charArr);
	}

	public static void reverse1(char[] charArr, int start, int end) {
		while (start < end) {
			char tmp = charArr[start];
			charArr[start] = charArr[end];
			charArr[end] = tmp;
			start++;
			end--;
		}
	}

	public static String rotate2(String str, int apartIndex) {
		if (str == null || apartIndex <= 0 || apartIndex >= str.length()) {
			return str;
		}
		char[] charArr = str.toCharArray();
		int start = 0;
		int end = charArr.length - 1;
		int leftSize = apartIndex;
		int rightSize = charArr.length - apartIndex;
		int size = Math.min(leftSize, rightSize);
		int sizeD = leftSize - rightSize;
		while (true) {
			reverse2(charArr, start, end, size);
			if (sizeD == 0) {
				break;
			} else if (sizeD > 0) {
				start += size;
				leftSize = sizeD;
			} else {
				end -= size;
				rightSize = -sizeD;
			}
			size = Math.min(leftSize, rightSize);
			sizeD = leftSize - rightSize;
		}
		return String.valueOf(charArr);
	}

	public static void reverse2(char[] charArr, int start, int end, int size) {
		int rightStart = end - size + 1;
		while (size-- != 0) {
			char tmp = charArr[start];
			charArr[start] = charArr[rightStart];
			charArr[rightStart] = tmp;
			start++;
			rightStart++;
		}
	}

	public static void main(String[] args) {
		String str = "12345ABC";
		System.out.println(rotate1(str, 5));
		System.out.println(rotate2(str, 5));

	}

}
