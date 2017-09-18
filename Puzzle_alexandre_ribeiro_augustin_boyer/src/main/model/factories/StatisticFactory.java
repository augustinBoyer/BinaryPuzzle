package main.model.factories;

import main.exceptions.NumberMatchesException;
import main.model.player.Statistic;

public class StatisticFactory {
	public static Statistic getStatistic() throws NumberMatchesException {
		return new Statistic();
	}
}
