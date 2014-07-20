package teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * User: Russ
 * Date: 7/19/14 5:11 PM
 */
public class SudokuReader {

	public static final int NUM_ROWS = 9;
	public static final int NUM_COLS = 9;

	public static int[][] readPuzzle(String puzzleFilename) {
		InputStreamReader puzzle = new InputStreamReader(SudokuReader.class.getResourceAsStream("/" + puzzleFilename));
		return readPuzzle(puzzle);
	}

	private static int[][] readPuzzle(Reader puzzle) {
		int[][] ret = new int[NUM_ROWS][NUM_COLS];
		BufferedReader lineReader = new BufferedReader(puzzle);

		try {
			int linesRead = 0;
			String line = lineReader.readLine();
			while (line != null) {
				linesRead++;
				if (linesRead > NUM_ROWS) {
					throw new RuntimeException("Bad input. Expected " + NUM_ROWS + " rows but found more");
				}
				if (line.length() != NUM_COLS) {
					throw new RuntimeException("Bad input. Expected " + NUM_COLS + " columns but found " + line.length());
				}

				int row = linesRead-1;
				for (int col=0; col<NUM_COLS; col++) {
					char ch = line.charAt(col);
					String str = String.valueOf(ch);
					int value = Integer.valueOf(str);
					ret[row][col] = value;
				}

				line = lineReader.readLine();
			}

			if (linesRead < NUM_ROWS) {
				throw new RuntimeException("Bad input. Expected " + NUM_ROWS + " rows but found " + linesRead);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}


		return ret;
	}



	public static void main(String[] args) {
		int[][] derp = readPuzzle("in1.txt");

		SudokuPrinter.printPuzzle(derp);
	}
}
