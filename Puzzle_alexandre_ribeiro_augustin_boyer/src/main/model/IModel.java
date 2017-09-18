package main.model;

import main.exceptions.GridSizeException;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;

public interface IModel {
	public void newGame(int size, int game, String firstName, String lastName)
			throws GridSizeException, NameException, NumberMatchesException;

	public void changeValue(int x, int y);
}
