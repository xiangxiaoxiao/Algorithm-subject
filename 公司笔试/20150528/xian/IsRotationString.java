package xian;

public class IsRotationString {

	public static boolean isRotation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		else {
			String str2Double = str2 + str2;
			if (str2Double.indexOf(str1) != -1) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		String str1 = "yunzuocheng";
		String str2 = "zuochengyun";
		System.out.println(isRotation(str1, str2));

	}

}
