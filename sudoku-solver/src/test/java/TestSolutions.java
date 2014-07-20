import org.testng.Assert;
import org.testng.annotations.Test;
import student.SudokuSolver;
import teacher.SolutionValidator;
import teacher.SudokuReader;

/**
 * User: Russ
 * Date: 7/19/14 6:29 PM
 */

public class TestSolutions {

	@Test
	public void testInput1() {
		doTestPuzzle("in1.txt");
	}

	@Test
	public void testInput2() {
		doTestPuzzle("in2.txt");
	}

	@Test
	public void testInput3() {
		doTestPuzzle("in3.txt");
	}

	@Test
	public void testInput4() {
		doTestPuzzle("in4.txt");
	}

	@Test
	public void testInput5() {
		doTestPuzzle("in5.txt");
	}

	@Test
	public void testInput6() {
		doTestPuzzle("in6.txt");
	}

	private void doTestPuzzle(String puzzleFilename) {
		int[][] puzzle = SudokuReader.readPuzzle(puzzleFilename);
		SudokuSolver solver = new SudokuSolver(puzzle);
		int[][] solvedPuzzle = solver.solve();
		Assert.assertTrue(SolutionValidator.isValidSolution(solvedPuzzle));
		//TODO RUSS add a comparison to actual solution
	}
}
