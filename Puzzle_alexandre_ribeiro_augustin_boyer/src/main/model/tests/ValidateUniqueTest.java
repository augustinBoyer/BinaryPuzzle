package main.model.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.exceptions.GridSizeException;
import main.model.factories.PuzzleFactory;
import main.model.square.GridManager;
import main.model.validator.ValidateUnique;

public class ValidateUniqueTest {

	@Test
	public void ValidateTest_GoodSolved_ExpectedTrue() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_GoodSolved().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_GoodSolved();
		grid.fillTable(game);
		ValidateUnique val = new ValidateUnique();

		Assert.assertTrue(val.validate(grid));
	}

	@Test
	public void ValidateTest_OneZeroMore_ExpectedTrue() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_OneZeroMore().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_OneZeroMore();
		grid.fillTable(game);
		ValidateUnique val = new ValidateUnique();

		Assert.assertTrue(val.validate(grid));
	}

	@Test
	public void Validate_OneOneMore_ExpectedTrue() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_OneOneMore().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_OneOneMore();
		grid.fillTable(game);
		ValidateUnique val = new ValidateUnique();
		Assert.assertTrue(val.validate(grid));
	}

	@Test
	public void ValidateTest_TwoSameRows_ExpectedFalse() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_TwoSameRows().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_TwoSameRows();
		grid.fillTable(game);
		ValidateUnique val = new ValidateUnique();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_TwoSameRows_AtBeginningAndAtEnd_ExpectedFalse() throws GridSizeException {
		GridManager grid = new GridManager(
				PuzzleFactory.getPuzzleTest_TwoSameRows_AtBeginningAndAtEnd().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_TwoSameRows_AtBeginningAndAtEnd();
		grid.fillTable(game);
		ValidateUnique val = new ValidateUnique();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_TwoSameColumns_ExpectedFalse() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_TwoSameColumns().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_TwoSameColumns();
		grid.fillTable(game);
		ValidateUnique val = new ValidateUnique();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_TwoSameColumns_AtBeginningAndAtEnd_ExpectedFalse() throws GridSizeException {
		GridManager grid = new GridManager(
				PuzzleFactory.getPuzzleTest_TwoSameColumns_AtBeginningAndAtEnd().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_TwoSameColumns_AtBeginningAndAtEnd();
		grid.fillTable(game);
		ValidateUnique val = new ValidateUnique();

		Assert.assertFalse(val.validate(grid));
	}

}
