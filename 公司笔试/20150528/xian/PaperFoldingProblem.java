package xian;

public class PaperFoldingProblem {

	public static void printAllFolds(int fTimes) {
		if (fTimes < 1) {
			return;
		}
		printProcess(1, fTimes, true);
		System.out.println();
	}

	public static void printProcess(int fIndex, int length, boolean isDown) {
		if (fIndex == length) {
			System.out.print(isDown ? "down " : "up ");
			return;
		}
		printProcess(fIndex + 1, length, true);
		System.out.print(isDown ? "down " : "up ");
		printProcess(fIndex + 1, length, false);
	}

	public static void main(String[] args) {
		int fTimes = 5;
		printAllFolds(fTimes);

	}
}
