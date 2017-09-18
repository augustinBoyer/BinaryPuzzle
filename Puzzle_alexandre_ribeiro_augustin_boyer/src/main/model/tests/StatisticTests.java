package main.model.tests;

import org.junit.Assert;
import org.junit.Test;

import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.factories.PlayerFactory;
import main.model.factories.StatisticFactory;
import main.model.player.Player;
import main.model.player.Statistic;

public class StatisticTests {
	public Boolean CompareResult(double expectedPercent, float percent) {

		return (percent - expectedPercent) < 0.001 && (percent - expectedPercent) > -0.001;
	}

	@Test
	public void StaticConstructor_NbPlayed_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		Assert.assertEquals(0, stat.getNbPlayed());
	}

	@Test
	public void StaticConstructor_NbResolved_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		Assert.assertEquals(0, stat.getNbResolved());
	}

	@Test
	public void setNbPlayed_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		stat.setNbPlayed(10);
		Assert.assertEquals(10, stat.getNbPlayed());
	}

	@Test(expected = NumberMatchesException.class)
	public void setNbResolved_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		stat.setNbResolved(10);
		Assert.assertEquals(10, stat.getNbResolved());
	}

	@Test(expected = NumberMatchesException.class)
	public void setNbPlayed_Exception_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		stat.setNbPlayed(-10);
	}

	@Test(expected = NumberMatchesException.class)
	public void setNbResolved_Exception_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		stat.setNbResolved(-10);
		Assert.assertEquals(-10, stat.getNbResolved());
	}

	@Test
	public void getPercentage_of0_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		Assert.assertTrue(this.CompareResult(0, stat.getPercentage()));
	}

	@Test
	public void getPercentage_of10_Test() throws NumberMatchesException {
		Statistic stat = StatisticFactory.getStatistic();
		stat.setNbPlayed(100);
		stat.setNbResolved(10);
		Assert.assertTrue(this.CompareResult(10, stat.getPercentage()));
	}

	@Test(expected = NumberMatchesException.class)
	public void test_UpdatePlayer_MoreResolvedThanPlayed() throws NameException, NumberMatchesException {

		Player player = PlayerFactory.getPlayer("TestFirstName", "TestLastName");

		Statistic stats = StatisticFactory.getStatistic();

		stats.setNbPlayed(8);
		stats.setNbResolved(4);

		player.setStats(stats);

		stats.setNbPlayed(5);
		stats.setNbResolved(8);
	}
}
