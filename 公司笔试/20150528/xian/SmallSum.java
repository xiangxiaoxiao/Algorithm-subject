package xian;

public class SmallSum {

	public static int getSmallSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return getSumByMergeSortProcess(arr, 0, arr.length - 1);
	}

	public static int getSumByMergeSortProcess(int[] arr, int start, int end) {
		if (start == end) {
			return 0;
		}
		if (start == end - 1) {
			if (arr[start] <= arr[end]) {
				return arr[start];
			} else {
				swap(arr, start, end);
				return 0;
			}
		}
		int mid = (start + end) / 2;
		int leftPart = getSumByMergeSortProcess(arr, start, mid);
		int rightPart = getSumByMergeSortProcess(arr, mid + 1, end);
		int mergeSum = mergeTwoParts(arr, start, mid, end);
		return leftPart + rightPart + mergeSum;
	}

	public static int mergeTwoParts(int[] arr, int start, int mid, int end) {
		int[] sortArr = new int[end - start + 1];
		int sortArrIndex = 0;
		int start1 = start;
		int end1 = mid;
		int start2 = mid + 1;
		int end2 = end;
		int res = 0;
		while (start1 <= end1 && start2 <= end2) {
			if (arr[start1] <= arr[start2]) {
				res += arr[start1] * (end2 - start2 + 1);
				sortArr[sortArrIndex++] = arr[start1++];
			} else {
				sortArr[sortArrIndex++] = arr[start2++];
			}
		}
		if (start1 > end1) {
			for (; start2 != end2 + 1;) {
				sortArr[sortArrIndex++] = arr[start2++];
			}
		} else {
			for (; start1 != end1 + 1;) {
				sortArr[sortArrIndex++] = arr[start1++];
			}
		}
		for (int i = 0; i != sortArr.length; i++) {
			arr[start++] = sortArr[i];
		}
		return res;
	}

	public static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4, 6, 2, 7, 8, 1 };
		System.out.println(getSmallSum(arr));

		int answer = (1) + (3 + 1 + 2) + (3 + 1 + 2 + 4) + (1 + 2)
				+ (3 + 1 + 2 + 4 + 6 + 2) + (3 + 1 + 2 + 4 + 6 + 2 + 7) + (1);
		System.out.println(answer);

	}

}
