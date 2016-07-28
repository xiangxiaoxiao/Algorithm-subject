package xian;

public class PrinMatrixSpiralOrder {

	public static void printMatrixBySpiralOrder(int[][] matrix) {
		if (matrix == null || matrix[0] == null) {
			return;
		}
		int upR = 0;
		int upC = 0;
		int downR = matrix.length - 1;
		int downC = matrix[0].length - 1;
		while (upR <= downR && upC <= downC) {
			if (upR == downR) {
				for (int i = upC; i <= downC; i++) {
					System.out.print(matrix[upR][i] + " ");
				}
			} else if (upC == downC) {
				for (int i = upR; i <= downR; i++) {
					System.out.print(matrix[i][upC] + " ");
				}
			} else {
				printEdge(matrix, upR, upC, downR, downC);
			}
			upR++;
			upC++;
			downR--;
			downC--;
		}
	}

	public static void printEdge(int[][] matrix, int upR, int upC, int downR,
			int downC) {
		int col = upC;
		while (col != downC) {
			System.out.print(matrix[upR][col] + " ");
			col++;
		}
		int row = upR;
		while (row != downR) {
			System.out.print(matrix[row][downC] + " ");
			row++;
		}
		while (col != upC) {
			System.out.print(matrix[downR][col] + " ");
			col--;
		}
		while (row != upR) {
			System.out.print(matrix[row][upC] + " ");
			row--;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrixBySpiralOrder(matrix);
	}

}
