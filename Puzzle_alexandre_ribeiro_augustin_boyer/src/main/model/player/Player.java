package main.model.player;

import main.exceptions.NameException;
import main.exceptions.NumberMatchesException;
import main.model.factories.StatisticFactory;

public class Player {
	private String firstName;
	private String lastName;
	private Statistic stats;

	public Player(String firstName, String lastName) throws NameException, NumberMatchesException {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStats(StatisticFactory.getStatistic());
	}

	public String getFirstName() {
		return this.firstName;
	}

	private void setFirstName(String firstName) throws NameException {
		if (firstName.trim() != "") {
			this.firstName = firstName;
		} else {
			throw new NameException("Le prénom ne peut être vide");
		}

	}

	public String getLastName() {
		return this.lastName;
	}

	private void setLastName(String lastName) throws NameException {
		if (lastName.trim() != "") {
			this.lastName = lastName;
		} else {
			throw new NameException("Le nom ne peut être vide");
		}
	}

	public Statistic getStats() {
		return this.stats;
	}

	public void setStats(Statistic stats) {
		this.stats = stats;
	}

	public void updateStats() throws NumberMatchesException {
		this.stats.addPlayedMatch();
	}

	public void updateWinStats() throws NumberMatchesException {
		this.stats.addResolvedMatch();
	}

	public int getNbPlayed() throws NumberMatchesException {
		return this.stats.getNbPlayed();
	}

	public int getNbResolved() throws NumberMatchesException {
		return this.stats.getNbResolved();
	}
}
