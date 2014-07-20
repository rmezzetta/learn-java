package teacher;

/**
 * User: Russ
 * Date: 7/19/14 5:43 PM
 */
public class SudokuPrinter {

	public static void printPuzzle(int[][] puzzle) {
		for (int[] row : puzzle) {
			for (int value : row) {
				System.out.print(value);
			}
			System.out.println("");
		}
	}
}
