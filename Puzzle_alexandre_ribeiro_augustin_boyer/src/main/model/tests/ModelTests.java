package main.model.tests;

import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import main.businesslayer.IPlayerRepository;
import main.businesslayer.persistance.MockPlayerDatabase;
import main.exceptions.GridSizeException;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.Model;
import main.model.factories.PlayerFactory;
import main.model.factories.PuzzleFactory;
import main.model.factories.StatisticFactory;
import main.model.player.Player;
import main.model.player.Statistic;
import main.model.validator.AbstractValidator;
import main.model.validator.ValidateAllSquaresFilled;
import main.model.validator.ValidateNumber;
import main.model.validator.ValidateSequence;
import main.model.validator.ValidateUnique;

public class ModelTests {

	@Test
	public void ModelTests_Constructor() throws NameException, NumberMatchesException, SQLException {
		IPlayerRepository repository = new MockPlayerDatabase();
		ArrayList<AbstractValidator> validators = new ArrayList<AbstractValidator>();

		Model model = new Model(repository, validators);

		Assert.assertTrue(model.getObservers().equals(validators));
	}

	@Test
	public void test_NewGame_PlayerDoesNotExists()
			throws NameException, NumberMatchesException, GridSizeException, SQLException {
		IPlayerRepository repository = new MockPlayerDatabase();
		ArrayList<AbstractValidator> validators = new ArrayList<AbstractValidator>();

		Model model = new Model(repository, validators);

		model.newGame(8, 1, "first", "last");

		Assert.assertEquals("first", repository.select("0").getFirstName());
	}

	@Test
	public void test_NewGame_PlayerAlreadyExists()
			throws NameException, NumberMatchesException, GridSizeException, SQLException {
		IPlayerRepository repository = new MockPlayerDatabase();
		Player player = PlayerFactory.getPlayer("fisrt", "last");
		repository.insert(player);
		ArrayList<AbstractValidator> validators = new ArrayList<AbstractValidator>();

		Model model = new Model(repository, validators);

		model.newGame(8, 1, "first", "last");

		Assert.assertEquals("first", repository.select("1").getFirstName());
	}

	@Test
	public void test_Validator_CompleteGrid()
			throws NameException, NumberMatchesException, GridSizeException, SQLException {
		IPlayerRepository repository = new MockPlayerDatabase();
		Player player = PlayerFactory.getPlayer("first", "last");
		Statistic stats = StatisticFactory.getStatistic();
		player.setStats(stats);
		repository.insert(player);

		ValidateAllSquaresFilled val1 = new ValidateAllSquaresFilled();
		ValidateNumber val2 = new ValidateNumber();
		ValidateSequence val3 = new ValidateSequence();
		ValidateUnique val4 = new ValidateUnique();
		ArrayList<AbstractValidator> validators = new ArrayList<>();
		validators.add(val1);
		validators.add(val2);
		validators.add(val3);
		validators.add(val4);

		Model model = new Model(repository, validators);
		model.newGame(PuzzleFactory.getPuzzleTest_GoodSolved().size(), -1, "first", "last");
		model.gameOverManager();
		Assert.assertEquals(1, repository.select("0").getNbResolved());
	}

	@Test
	public void test_Validator_IncompleteGrid()
			throws NameException, NumberMatchesException, GridSizeException, SQLException {
		IPlayerRepository repository = new MockPlayerDatabase();
		Player player = PlayerFactory.getPlayer("first", "last");
		Statistic stats = StatisticFactory.getStatistic();
		player.setStats(stats);
		repository.insert(player);

		ValidateAllSquaresFilled val1 = new ValidateAllSquaresFilled();
		ValidateNumber val2 = new ValidateNumber();
		ValidateSequence val3 = new ValidateSequence();
		ValidateUnique val4 = new ValidateUnique();
		ArrayList<AbstractValidator> validators = new ArrayList<>();
		validators.add(val1);
		validators.add(val2);
		validators.add(val3);
		validators.add(val4);

		Model model = new Model(repository, validators);
		model.newGame(8, 1, "first", "last");
		model.gameOverManager();
		Assert.assertEquals(0, repository.select("0").getNbPlayed());
		Assert.assertEquals(0, repository.select("0").getNbResolved());
	}
}
