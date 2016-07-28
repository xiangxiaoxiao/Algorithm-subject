package xian;

public class UniqueCharString {

	public static boolean isUnique1(String str) {
		if (str == null) {
			return true;
		}
		char[] charArr = str.toCharArray();
		boolean[] map = new boolean[256];
		for (int i = 0; i != charArr.length; i++) {
			if (map[charArr[i]]) {
				return false;
			}
			map[charArr[i]] = true;
		}
		return true;
	}

	public static boolean isUnique2(String str) {
		if (str == null) {
			return true;
		}
		char[] charArr = str.toCharArray();
		heapSort(charArr);
		for (int i = 1; i != charArr.length; i++) {
			if (charArr[i] == charArr[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void heapSort(char[] arr) {
		for (int i = 0; i != arr.length; i++) {
			heapInsert(arr, i);
		}
		for (int i = arr.length - 1; i != 0; i--) {
			swap(arr, 0, i);
			heapify(arr, 0, i);
		}
	}

	public static void heapInsert(char[] arr, int index) {
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (arr[parent] < arr[index]) {
				swap(arr, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}

	public static void heapify(char[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < heapSize) {
			if (arr[left] > arr[index]) {
				largest = left;
			}
			if (right < heapSize && arr[right] > arr[largest]) {
				largest = right;
			}
			if (largest != index) {
				swap(arr, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}

	public static void swap(char[] arr, int index1, int index2) {
		char tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void main(String[] args) {
		String str = "123abcd456";
		System.out.println(isUnique1(str));
		System.out.println(isUnique2(str));

	}

}
