package xian;

public class PrintMatrixZigZag {

	public static void printMatrixZigZag(int[][] matrix) {
		if (matrix == null || matrix[0] == null) {
			return;
		}
		int upR = 0;
		int upC = 0;
		int downR = 0;
		int downC = 0;
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;
		while (upR != endR + 1) {
			printLevel(matrix, upR, upC, downR, downC, fromUp);
			upR = upC == endC ? upR + 1 : upR;
			upC = upC == endC ? upC : upC + 1;
			downC = downR == endR ? downC + 1 : downC;
			downR = downR == endR ? downR : downR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] matrix, int upR, int upC, int downR,
			int downC, boolean fromUp) {
		if (fromUp) {
			while (upR != downR + 1) {
				System.out.print(matrix[upR++][upC--] + " ");
			}
		} else {
			while (downR != upR - 1) {
				System.out.print(matrix[downR--][downC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrixZigZag(matrix);

	}

}
