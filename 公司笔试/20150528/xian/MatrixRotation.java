package xian;

public class MatrixRotation {

	public static void rotate(int[][] m) {
		if (m == null || m[0] == null || m.length != m[0].length) {
			return;
		}
		int tR = 0;
		int tC = 0;
		int bR = m.length - 1;
		int bC = m[0].length - 1;
		while (tR < bR) {
			rotateLevel(m, tR++, tC++, bR--, bC--);
		}
	}

	public static void rotateLevel(int[][] m, int tR, int tC, int bR, int bC) {
		int times = bC - tC;
		for (int i = 0; i != times; i++) {
			int tmp = m[tR][tC + i];
			m[tR][tC + i] = m[bR - i][tC];
			m[bR - i][tC] = m[bR][bC - i];
			m[bR][bC - i] = m[tR + i][bC];
			m[tR + i][bC] = tmp;
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("======");
		printMatrix(matrix);

	}

}
