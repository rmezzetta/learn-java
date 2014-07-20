package teacher;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Russ
 * Date: 7/19/14 5:51 PM
 */
public class SolutionValidator {

	/**
	 * This method is purposefully not giving feedback. You need to figure out why the puzzle is wrong for yourself!
	 */
	public static boolean isValidSolution(int[][] puzzle) {
		if (puzzle == null) {
			return false;
		}
		if (!allValuesBetweenOneAndNine(puzzle)) {
			return false;
		}
		if (!rowsContainOneThroughNine(puzzle)) {
			return false;
		}
		if (!columnsContainOneThroughNine(puzzle)) {
			return false;
		}
		if (!eachSectionContainsOneThroughNine(puzzle)) {
			return false;
		}
		return true;
	}

	private static boolean eachSectionContainsOneThroughNine(int[][] puzzle) {
		//Top left section is 0,0
		//Bottom right section is 2,2
		for (int sectionX = 0; sectionX < Constants.NUM_SECTIONS_WIDE; sectionX++) {
			for (int sectionY = 0; sectionY < Constants.NUM_SECTIONS_TALL; sectionY++) {
				int startColIndex = sectionX * Constants.NUM_COLS_IN_SECTION;
				int startRowIndex = sectionY * Constants.NUM_ROWS_IN_SECTION;

				Set<Integer> valuesInSection = new HashSet<Integer>();
				for (int col = startColIndex; col < startColIndex + Constants.NUM_COLS_IN_SECTION; col++) {
					for (int row = startRowIndex; row < startRowIndex + Constants.NUM_ROWS_IN_SECTION; row++) {
						valuesInSection.add(puzzle[row][col]);
					}
				}
				if (valuesInSection.size() != Constants.NUM_VALUES_IN_SECTION) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean columnsContainOneThroughNine(int[][] puzzle) {
		for (int col = 0; col < Constants.NUM_COLS; col++) {
			Set<Integer> valuesFoundInColumn = new HashSet<Integer>();
			for (int row = 0; row < Constants.NUM_ROWS; row++) {
				valuesFoundInColumn.add(puzzle[row][col]);
			}
			if (valuesFoundInColumn.size() != Constants.NUM_ROWS) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Assumes allValuesBetweenOneAndNine has been called before this
	 */
	private static boolean rowsContainOneThroughNine(int[][] puzzle) {
		for (int[] row : puzzle) {
			Set<Integer> valuesFoundInRow = new HashSet<Integer>();
			for (int value : row) {
				valuesFoundInRow.add(value);
			}
			if (valuesFoundInRow.size() != Constants.NUM_COLS) {
				return false;
			}
		}
		return true;
	}

	private static boolean allValuesBetweenOneAndNine(int[][] puzzle) {
		for (int[] row : puzzle) {
			for (int value : row) {
				if (value < Constants.MIN_VAL || value > Constants.MAX_VAL) {
					return false;
				}
			}
		}
		return true;
	}
}
