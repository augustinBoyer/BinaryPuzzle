package main.model.tests;

import org.junit.Assert;
import org.junit.Test;

import main.businesslayer.persistance.MockPlayerDatabase;
import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.factories.PlayerFactory;
import main.model.factories.StatisticFactory;
import main.model.player.Player;
import main.model.player.Statistic;

public class RepositoryTests {

	@Test
	public void test_InsertPlayer() throws NameException, NumberMatchesException {

		MockPlayerDatabase mock = new MockPlayerDatabase();

		Player player = PlayerFactory.getPlayer("TestFirstName", "TestLastName");

		mock.insert(player);

		Assert.assertEquals(player, mock.select("0"));
	}

	@Test
	public void test_InsertPlayer_PlayerNull() throws NameException, NumberMatchesException {

		MockPlayerDatabase mock = new MockPlayerDatabase();
		mock.insert(null);
		Assert.assertEquals(0, mock.getPlayerList().size());
	}

	@Test
	public void test_InsertPlayer_TwoPlayersEquals() throws NameException, NumberMatchesException {

		MockPlayerDatabase mock = new MockPlayerDatabase();

		Player player = PlayerFactory.getPlayer("TestFirstName", "TestLastName");

		mock.insert(player);
		mock.insert(player);

		Assert.assertEquals(player, mock.select("0"));
		Assert.assertEquals(1, mock.getPlayerList().size());
		Assert.assertEquals(mock.getPlayerList().get(0), player);

	}

	@Test
	public void test_UpdatePlayer() throws NameException, NumberMatchesException {

		MockPlayerDatabase mock = new MockPlayerDatabase();

		Player player = PlayerFactory.getPlayer("TestFirstName", "TestLastName");

		mock.insert(player);

		Statistic stats = StatisticFactory.getStatistic();

		player.setStats(stats);

		mock.insert(player);

		stats.addPlayedMatch();
		stats.addResolvedMatch();

		player.setStats(stats);

		mock.update(player, "0");

		Player playerTwo = mock.select("0");

		Assert.assertEquals(1, playerTwo.getNbPlayed());
		Assert.assertEquals(1, playerTwo.getNbResolved());
	}
}
