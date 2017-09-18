package main.model.tests;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.exceptions.GridSizeException;
import main.model.factories.PuzzleFactory;
import main.model.square.GridManager;
import main.model.validator.AbstractValidator;
import main.model.validator.GameOverManager;
import main.model.validator.ValidateAllSquaresFilled;
import main.model.validator.ValidateNumber;
import main.model.validator.ValidateSequence;
import main.model.validator.ValidateUnique;

public class GameOverManagerTests {

	@Test
	public void GameOverManagerTests_AllValidatorsCorrect() throws GridSizeException {
		ValidateAllSquaresFilled val1 = new ValidateAllSquaresFilled();
		ValidateNumber val2 = new ValidateNumber();
		ValidateSequence val3 = new ValidateSequence();
		ValidateUnique val4 = new ValidateUnique();
		ArrayList<AbstractValidator> validators = new ArrayList<>();
		validators.add(val1);
		validators.add(val2);
		validators.add(val3);
		validators.add(val4);
		GameOverManager manager = new GameOverManager(validators, null);
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_GoodSolved().size(), null);
		grid.fillTable(PuzzleFactory.getPuzzleTest_GoodSolved());

		Assert.assertTrue(manager.validate(grid));
	}

	@Test
	public void GameOverManagerTests_OneValidatorCorrect() throws GridSizeException {
		ValidateAllSquaresFilled val1 = new ValidateAllSquaresFilled();
		ValidateNumber val2 = new ValidateNumber();
		ValidateSequence val3 = new ValidateSequence();
		ValidateUnique val4 = new ValidateUnique();
		ArrayList<AbstractValidator> validators = new ArrayList<>();
		validators.add(val1);
		validators.add(val2);
		validators.add(val3);
		validators.add(val4);
		GameOverManager manager = new GameOverManager(validators, null);
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_OneZeroMore().size(), null);
		grid.fillTable(PuzzleFactory.getPuzzleTest_OneZeroMore());

		Assert.assertFalse(manager.validate(grid));
	}

	@Test
	public void GameOverManagerTests_NoValidatorCorrect() throws GridSizeException {
		ValidateAllSquaresFilled val1 = new ValidateAllSquaresFilled();
		ValidateNumber val2 = new ValidateNumber();
		ValidateSequence val3 = new ValidateSequence();
		ValidateUnique val4 = new ValidateUnique();
		ArrayList<AbstractValidator> validators = new ArrayList<>();
		validators.add(val1);
		validators.add(val2);
		validators.add(val3);
		validators.add(val4);
		GameOverManager manager = new GameOverManager(validators, null);
		GridManager grid = new GridManager(PuzzleFactory.getPuzzleTest_NothingButZeros().size(), null);
		grid.fillTable(PuzzleFactory.getPuzzleTest_NothingButZeros());

		Assert.assertFalse(manager.validate(grid));
	}
}
