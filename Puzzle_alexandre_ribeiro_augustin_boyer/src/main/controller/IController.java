package main.controller;

import java.util.ArrayList;

import main.exceptions.GridSizeException;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.validator.AbstractValidator;

public interface IController {
	public void newGame(int size, int game, String firstName, String lastName)
			throws GridSizeException, NameException, NumberMatchesException;

	public void changeValue(int x, int y);

	public ArrayList<AbstractValidator> getValidators();

	public void textFieldsVaidate(String firstName, String lastName);
}
