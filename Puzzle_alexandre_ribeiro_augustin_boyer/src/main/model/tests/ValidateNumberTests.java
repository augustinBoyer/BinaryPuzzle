package main.model.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.exceptions.GridSizeException;
import main.model.factories.PuzzleFactory;
import main.model.square.GridManager;
import main.model.validator.ValidateNumber;

public class ValidateNumberTests {

	@Test
	public void ValidateTest_ExpectedTrue() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_GoodSolved().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_GoodSolved();
		grid.fillTable(game);
		ValidateNumber val = new ValidateNumber();

		Assert.assertTrue(val.validate(grid));
	}

	@Test
	public void ValidateTest() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_OneZeroMore().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_OneZeroMore();
		grid.fillTable(game);
		ValidateNumber val = new ValidateNumber();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void Validate_ThreeLastCellsAre1() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_OneOneMore().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_OneOneMore();
		grid.fillTable(game);
		ValidateNumber val = new ValidateNumber();
		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_OK() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_TwoSameRows().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_TwoSameRows();
		grid.fillTable(game);
		ValidateNumber val = new ValidateNumber();
		Assert.assertFalse(val.validate(grid));
	}
}
