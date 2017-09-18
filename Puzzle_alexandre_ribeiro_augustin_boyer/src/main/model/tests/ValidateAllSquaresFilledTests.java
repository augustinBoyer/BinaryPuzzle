package main.model.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.exceptions.GridSizeException;
import main.model.factories.PuzzleFactory;
import main.model.square.GridManager;
import main.model.validator.ValidateAllSquaresFilled;

public class ValidateAllSquaresFilledTests {
	@Test
	public void ValidateTest() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzle(1).get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzle(1);
		grid.fillTable(game);
		ValidateAllSquaresFilled val = new ValidateAllSquaresFilled();
		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void Validate_AllSquareFilledTest() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_OneZeroMore().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest1();
		grid.fillTable(game);
		ValidateAllSquaresFilled val = new ValidateAllSquaresFilled();
		Assert.assertTrue(val.validate(grid));
	}
}
