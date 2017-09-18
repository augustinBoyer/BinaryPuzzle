package main.model.player;

import main.exceptions.NumberMatchesException;

public class Statistic {
	private int nbPlayed;
	private int nbResolved;

	private final static String NEGATIVE_MATCH_NUMBER_EXCEPTION_MESSAGE = "Le nombre de match doit être positif";
	private final static String RESOLVED_MATCH_GREATER_THAN_PLAYED_EXCEPTION_MESSAGE = "Le nombre de match gagnée ne peut pas être plus grand que les matchs jouées";

	public Statistic() throws NumberMatchesException {
		this.setNbPlayed(0);
		this.setNbResolved(0);
	}

	public int getNbPlayed() {
		return this.nbPlayed;
	}

	public void setNbPlayed(int nbPlayed) throws NumberMatchesException {
		if (!this.verifyPlayedGreaterThanResolved(nbPlayed, this.nbResolved)) {
			throw new NumberMatchesException(this.RESOLVED_MATCH_GREATER_THAN_PLAYED_EXCEPTION_MESSAGE);
		} else if (nbPlayed < 0) {
			throw new NumberMatchesException(this.NEGATIVE_MATCH_NUMBER_EXCEPTION_MESSAGE);
		} else {
			this.nbPlayed = nbPlayed;
		}
	}

	public int getNbResolved() {
		return this.nbResolved;
	}

	public void setNbResolved(int nbResolved) throws NumberMatchesException {
		if (!this.verifyPlayedGreaterThanResolved(this.nbPlayed, nbResolved)) {
			throw new NumberMatchesException(this.RESOLVED_MATCH_GREATER_THAN_PLAYED_EXCEPTION_MESSAGE);
		} else if (nbResolved < 0) {
			throw new NumberMatchesException(this.NEGATIVE_MATCH_NUMBER_EXCEPTION_MESSAGE);
		} else {
			this.nbResolved = nbResolved;
		}
	}

	public float getPercentage() {
		float percentage = 0;
		if (this.getNbPlayed() != 0) {
			percentage = this.getNbResolved() * 100 / this.getNbPlayed();
		}
		return percentage;
	}

	public void addPlayedMatch() throws NumberMatchesException {
		this.setNbPlayed(this.getNbPlayed() + 1);
	}

	public void addResolvedMatch() throws NumberMatchesException {
		this.setNbResolved(this.getNbResolved() + 1);
	}

	public Boolean verifyPlayedGreaterThanResolved(int played, int solved) {
		return played >= solved;
	}
}
