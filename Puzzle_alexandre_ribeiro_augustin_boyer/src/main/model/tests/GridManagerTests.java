package main.model.tests;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import main.exceptions.GridSizeException;
import main.model.factories.PuzzleFactory;
import main.model.square.GridManager;
import main.model.square.Square;

public class GridManagerTests {

	@Test
	public void GridManager_test_GetSize() throws GridSizeException {

		ArrayList<main.view.Observer> list = new ArrayList<main.view.Observer>();

		GridManager grid = new GridManager(8, list);
		Assert.assertEquals(8, grid.getSize());
	}

	@Test
	public void GridManager_test_FillTable() throws GridSizeException {

		ArrayList<main.view.Observer> list = new ArrayList<main.view.Observer>();

		GridManager grid = new GridManager(8, list);

		grid.setTable(new Square[8][8]);

		ArrayList<String> puzzle = PuzzleFactory.getPuzzle(1);

		grid.fillTable(puzzle);
		Assert.assertEquals(grid.getSquareValue(0, 0), " ");
		Assert.assertEquals(grid.getSquareValue(1, 1), "0");

		Assert.assertEquals(grid.getSquareValue(7, 7), "1");
	}

	@Test
	public void GridManager_test_GetSquare() throws GridSizeException {

		ArrayList<main.view.Observer> list = new ArrayList<main.view.Observer>();

		GridManager grid = new GridManager(8, list);

		grid.setTable(new Square[8][8]);

		ArrayList<String> puzzle = PuzzleFactory.getPuzzle(1);

		grid.fillTable(puzzle);

		Square otherSquare = grid.getSquare(0, 0);
		Square otherSquare1 = grid.getSquare(1, 1);
		Square otherSquare2 = grid.getSquare(7, 7);

		Assert.assertEquals(" ", otherSquare.getValue());
		Assert.assertEquals(otherSquare1.getValue(), "0");
		Assert.assertEquals(otherSquare2.getValue(), "1");
	}

	@Test(expected = GridSizeException.class)
	public void test_ImpairNumber() throws GridSizeException {
		ArrayList<main.view.Observer> list = new ArrayList<main.view.Observer>();

		@SuppressWarnings("unused")
		GridManager grid = new GridManager(9, list);
	}

	@Test(expected = GridSizeException.class)
	public void test_NegativeNumber() throws GridSizeException {
		ArrayList<main.view.Observer> list = new ArrayList<main.view.Observer>();

		@SuppressWarnings("unused")
		GridManager grid = new GridManager(-10, list);
	}
}
