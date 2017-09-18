package main.model;

import java.util.ArrayList;

import main.view.Observer;

public class Observed {
	private ArrayList<Observer> observers = new ArrayList<>();

	public ArrayList<Observer> getObservers() {
		return this.observers;
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void alertAllToNewSquare(int i, int j, String s) {
		for (Observer o : this.observers) {
			o.reactToNewSquare(i, j, s);
		}
	}

	public void alertAllToChangedSquare(int i, int j, String s) {
		for (Observer o : this.observers) {
			o.reactToChangedSquare(i, j, s);
		}
	}

	public void alertAllToGameOver(String message) {
		for (Observer o : this.observers) {
			o.reactToGameOver(message);
		}
	}

	public void alertAllToPlayerUpdate(String nbPlayed, String nbResolved) {
		for (Observer o : this.observers) {
			o.reactToPlayerUpdate(nbPlayed, nbResolved);
		}
	}

	public void alertAllToIncompleteGrid(String message) {
		for (Observer o : this.observers) {
			o.reactToIncompleteGrid(message);
		}
	}

	public void alertAllToNewGame(String playerName, String nbPlayed, String nbResolved) {
		for (Observer o : this.observers) {
			o.reactToNewGame(playerName, nbPlayed, nbResolved);
		}
	}
}
