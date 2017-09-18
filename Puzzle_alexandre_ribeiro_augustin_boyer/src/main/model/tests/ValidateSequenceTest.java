package main.model.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.exceptions.GridSizeException;
import main.model.factories.PuzzleFactory;
import main.model.square.GridManager;
import main.model.validator.ValidateSequence;

public class ValidateSequenceTest {

	@Test
	public void ValidateTest_ExpectedTrue() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_GoodSolved().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_GoodSolved();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertTrue(val.validate(grid));
	}

	@Test
	public void ValidateTest_OK() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_OneZeroMore().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_OneZeroMore();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertTrue(val.validate(grid));
	}

	@Test
	public void ValidateTest_FirstSequenceZero() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_FirstSequenceZero().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_FirstSequenceZero();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_FirstSequenceOne() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_FirstSequenceOne().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_FirstSequenceOne();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_LastSequenceZero() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_LastSequenceZero().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_LastSequenceZero();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_LastSequenceOne() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_LastSequenceOne().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_LastSequenceOne();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_FirstSequenceZeroAtRow() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_FirstSequenceZeroAtRow().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_FirstSequenceZeroAtRow();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_FirstSequenceOneAtRow() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_FirstSequenceOneAtRow().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_FirstSequenceOneAtRow();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_LastSequenceZeroAtRow() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_LastSequenceZeroAtRow().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_LastSequenceZeroAtRow();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_LastSequenceOneAtRow() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_LastSequenceOneAtRow().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_LastSequenceOneAtRow();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_MiddleSequenceZeroAtColumn() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_MiddleSequenceOneAtColumn().get(0).length(),
				null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_MiddleSequenceOneAtColumn();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_MiddleSequenceOneAtColumn() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_MiddleSequenceZeroAtColumn().get(0).length(),
				null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_MiddleSequenceZeroAtColumn();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_MiddleSequenceZeroAtRow() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_MiddleSequenceOneAtRow().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_MiddleSequenceOneAtRow();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}

	@Test
	public void ValidateTest_MiddleSequenceOneAtRow() throws GridSizeException {
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_MiddleSequenceZeroAtRow().get(0).length(), null);
		ArrayList<String> game = PuzzleFactory.getPuzzleTest_MiddleSequenceZeroAtRow();
		grid.fillTable(game);
		ValidateSequence val = new ValidateSequence();

		Assert.assertFalse(val.validate(grid));
	}
}
