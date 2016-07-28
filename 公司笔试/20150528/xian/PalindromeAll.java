package xian;

public class PalindromeAll {

	public static String generateASPByLPS(String str, String LPS) {
		if (str == null || str.equals("")) {
			return "";
		}
		char[] chars = str.toCharArray();
		char[] charLPS = LPS.toCharArray();
		char[] res = new char[2 * chars.length - charLPS.length];
		int lpsLeft = 0;
		int lpsRight = charLPS.length - 1;
		int charLeft = 0;
		int charRight = chars.length - 1;
		int resLeft = 0;
		int resRight = res.length - 1;
		while (lpsLeft <= lpsRight) {
			int tmpLeft = charLeft;
			int tmpRight = charRight;
			while (chars[charLeft] != charLPS[lpsLeft]) {
				charLeft++;
			}
			while (chars[charRight] != charLPS[lpsRight]) {
				charRight--;
			}
			setTwoUnPalindromePartToResult(res, resLeft, resRight, chars,
					tmpLeft, charLeft, charRight, tmpRight);
			resLeft += charLeft - tmpLeft + tmpRight - charRight;
			resRight -= charLeft - tmpLeft + tmpRight - charRight;
			res[resLeft++] = chars[charLeft++];
			res[resRight--] = chars[charRight--];
			lpsLeft++;
			lpsRight--;
		}
		return String.valueOf(res);
	}

	public static void setTwoUnPalindromePartToResult(char[] res, int resLeft,
			int resRight, char[] chars, int leftStart, int leftEnd,
			int rightStart, int rightEnd) {
		for (int i = leftStart; i != leftEnd; i++) {
			res[resLeft++] = chars[i];
			res[resRight--] = chars[i];
		}
		for (int i = rightEnd; i != rightStart; i--) {
			res[resLeft++] = chars[i];
			res[resRight--] = chars[i];
		}
	}

	public static void main(String[] args) {
		String str = "B1G2TY34I3OPX2S1";
		String strLPS = "123I321";
		String result = generateASPByLPS(str, strLPS);
		System.out.println(str + " shortest all palindrome string: " + result);
	}

}
