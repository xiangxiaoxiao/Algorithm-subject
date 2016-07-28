package xian;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class FindKMajorityNumber {

	public static void printHalfMajor(int[] arr) {
		int cand = 0;
		int times = 0;
		for (int i = 0; i != arr.length; i++) {
			if (times == 0) {
				cand = arr[i];
				times = 1;
			} else if (arr[i] == cand) {
				times++;
			} else {
				times--;
			}
		}
		times = 0;
		for (int i = 0; i != arr.length; i++) {
			if (arr[i] == cand) {
				times++;
			}
		}
		System.out.println(times > arr.length / 2 ? cand : "no number");
	}

	public static void printKMajor(int[] arr, int K) {
		if (K < 2) {
			System.out.println("K is invalid.");
			return;
		}
		HashMap<Integer, Integer> kMajor = new HashMap<Integer, Integer>();
		for (int i = 0; i != arr.length; i++) {
			if (kMajor.containsKey(arr[i])) {
				kMajor.put(arr[i], kMajor.get(arr[i]) + 1);
			} else {
				if (kMajor.size() == K - 1) {
					allCandsMinusOne(kMajor);
				} else {
					kMajor.put(arr[i], 1);
				}
			}
		}
		HashMap<Integer, Integer> realMap = getRealMap(arr, kMajor);
		boolean hasPrint = false;
		for (Entry<Integer, Integer> set : kMajor.entrySet()) {
			Integer key = set.getKey();
			if (realMap.get(key) > arr.length / K) {
				hasPrint = true;
				System.out.print(key + " ");
			}
		}
		System.out.println(hasPrint ? "" : "no number");
	}

	public static void allCandsMinusOne(HashMap<Integer, Integer> map) {
		List<Integer> removeList = new LinkedList<Integer>();
		for (Entry<Integer, Integer> set : map.entrySet()) {
			Integer key = set.getKey();
			Integer value = set.getValue();
			if (value == 1) {
				removeList.add(key);
			}
			map.put(key, value - 1);
		}
		for (Integer removeKey : removeList) {
			map.remove(removeKey);
		}
	}

	public static HashMap<Integer, Integer> getRealMap(int[] arr,
			HashMap<Integer, Integer> kMajor) {
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		for (int i = 0; i != arr.length; i++) {
			int curNum = arr[i];
			if (kMajor.containsKey(curNum)) {
				if (res.containsKey(curNum)) {
					res.put(curNum, res.get(curNum) + 1);
				} else {
					res.put(curNum, 1);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 1, 1, 2, 1 };
		printHalfMajor(arr);
		int K = 4;
		printKMajor(arr, K);
	}

}
