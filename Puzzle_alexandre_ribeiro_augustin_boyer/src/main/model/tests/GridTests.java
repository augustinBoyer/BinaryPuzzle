package main.model.tests;

import java.util.ArrayList;
import org.junit.Test;
import main.exceptions.GridSizeException;
import main.model.square.GridManager;

public class GridTests {

	@Test(expected = GridSizeException.class)
	public void test() throws GridSizeException {
		ArrayList<main.view.Observer> list = new ArrayList<main.view.Observer>();

		@SuppressWarnings("unused")
		GridManager grid = new GridManager(9, list);
	}

}
